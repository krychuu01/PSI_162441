package pl.bookstore.orders_info;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.books.Book;
import pl.bookstore.books.crud.BookReader;
import pl.bookstore.orders.Order;
import pl.bookstore.orders.OrderReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OrdersInfoCreator {

    private final OrderInfoRepository orderInfoRepository;
    private final OrderReader orderReader;
    private final BookReader bookReader;

    public void addOrderInfoForEachBook(Order order, List<Book> booksList, Map<Long, Integer> bookIdAndAmountMap) {
        var orderInfoList = new ArrayList<OrderInfo>();

        for (Book book: booksList) {
            var orderedAmount = bookIdAndAmountMap.get(book.getId());
            var priceForOrderedAmount = book.getPrice() * orderedAmount;
            var orderInfo = OrderInfo.builder()
                    .order(orderReader.getReferenceById(order.getId()))
                    .book(bookReader.getReferenceById(book.getId()))
                    .booksAmount(orderedAmount)
                    .price(priceForOrderedAmount)
                    .build();

            orderInfoList.add(orderInfo);
        }

        orderInfoRepository.saveAllAndFlush(orderInfoList);
    }


}
