package pl.bookstore.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.orders.dtos.OrderDto;
import pl.bookstore.orders.dtos.OrderedBooksDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderCreator creator;
    private final OrderReader reader;

    public MessageListDto placeAnOrder(Long userId, OrderedBooksDto orderedBooks) {
        return creator.placeAnOrder(userId, orderedBooks);
    }

    public List<? extends EntityDto<Order>> getUserOrders(Long userId) {
        return reader.getUserOrders(userId);
    }

}
