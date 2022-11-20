package pl.bookstore.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.books.Book;
import pl.bookstore.books.BookRepository;
import pl.bookstore.orders.dtos.OrderedBooksDto;
import pl.bookstore.orders_info.OrderInfo;
import pl.bookstore.orders_info.OrderInfoRepository;
import pl.bookstore.users.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OrderCreator {

    private final OrderRepository orderRepository;
    private final OrderInfoRepository orderInfoRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public MessageListDto placeAnOrder(Long userId, OrderedBooksDto orderedBooks) {
        var messageList = new MessageListDto();
        var order = createNewOrder(userId);
        var booksList = findBooksByIds(orderedBooks);

        addOrderInfoForEachBook(order, booksList, orderedBooks.bookIdAndAmountMap());
        setOrderTotalPrice(order, booksList, orderedBooks.bookIdAndAmountMap());

        messageList.buildMessage("placed an order.");
        return messageList;
    }

    private void addOrderInfoForEachBook(Order order, List<Book> booksList, Map<Long, Integer> bookIdAndAmountMap) {
        var orderInfoList = new ArrayList<OrderInfo>();

        for (Book book: booksList) {
            var orderedAmount = bookIdAndAmountMap.get(book.getId());
            var priceForOrderedAmount = book.getPrice() * orderedAmount;
            var orderInfo = OrderInfo.builder()
                    .order(orderRepository.getReferenceById(order.getId()))
                    .book(bookRepository.getReferenceById(book.getId()))
                    .booksAmount(orderedAmount)
                    .price(priceForOrderedAmount)
                    .build();

            orderInfoList.add(orderInfo);
        }

        orderInfoRepository.saveAllAndFlush(orderInfoList);
    }

    private void setOrderTotalPrice(Order order, List<Book> booksList, Map<Long, Integer> bookIdAndAmountMap) {
        for (Book book: booksList) {
            var orderedAmount = bookIdAndAmountMap.get(book.getId());
            var priceForOrderedAmount = book.getPrice() * orderedAmount;
            order.addValueToTotalPrice(priceForOrderedAmount);
        }
        orderRepository.saveAndFlush(order);
    }

    private Order createNewOrder(Long userId) {
        var order = new Order();
        order.setUser(userRepository.getReferenceById(userId));
        orderRepository.saveAndFlush(order);
        return order;
    }

    private List<Book> findBooksByIds(OrderedBooksDto orderedBooks) {
        return bookRepository.findByIdIn(orderedBooks.bookIdAndAmountMap().keySet());
    }

}
