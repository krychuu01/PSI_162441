package pl.bookstore.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.books.Book;
import pl.bookstore.books.crud.BookReader;
import pl.bookstore.orders.dtos.OrderedBooksDto;
import pl.bookstore.orders_info.OrdersInfoCreator;
import pl.bookstore.users.crud.UserReader;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderCreator {

    private final OrderRepository orderRepository;
    private final UserReader userReader;
    private final BookReader bookReader;
    private final OrdersInfoCreator ordersInfoCreator;

    public MessageListDto placeAnOrder(Long userId, OrderedBooksDto orderedBooks) {
        var messageList = new MessageListDto();
        var order = createNewOrder(userId);

        var booksList = bookReader.findBooksByIds(orderedBooks.bookIdAndAmountMap().keySet());

        ordersInfoCreator.addOrderInfoForEachBook(order, booksList, orderedBooks.bookIdAndAmountMap());
        setOrderTotalPrice(order, booksList, orderedBooks);

        messageList.buildMessage("placed an order.");
        return messageList;
    }

    private void setOrderTotalPrice(Order order, List<Book> booksList, OrderedBooksDto orderedBooks) {
        for (Book book: booksList) {
            var orderedAmount = orderedBooks.bookIdAndAmountMap().get(book.getId());
            var priceForOrderedAmount = book.getPrice() * orderedAmount;
            order.addValueToTotalPrice(priceForOrderedAmount);
        }
        order.calculateFinalPrice(orderedBooks.discount());
        orderRepository.saveAndFlush(order);
    }

    private Order createNewOrder(Long userId) {
        var order = new Order();
        order.setUser(userReader.getReferenceById(userId));
        orderRepository.saveAndFlush(order);
        return order;
    }
}
