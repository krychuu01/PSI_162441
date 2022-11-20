package pl.bookstore.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.orders.dtos.OrderedBooksDto;

@Component
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderCreator creator;

    public MessageListDto placeAnOrder(Long userId, OrderedBooksDto orderedBooks) {
        return creator.placeAnOrder(userId, orderedBooks);
    }

}
