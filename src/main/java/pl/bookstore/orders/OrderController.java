package pl.bookstore.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.orders.dtos.OrderedBooksDto;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderFacade facade;

    @GetMapping("/{userId}")
    public List<? extends EntityDto<Order>> getOrdersByUserId(@PathVariable Long userId) {
        return facade.getUserOrders(userId);
    }

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageListDto createOrder(@PathVariable Long userId, @RequestBody OrderedBooksDto dto) {
        return facade.placeAnOrder(userId, dto);
    }

}
