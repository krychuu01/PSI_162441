package pl.bookstore.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.orders.dtos.OrderedBooksDto;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderFacade facade;

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageListDto createOrder(@PathVariable Long id, @RequestBody OrderedBooksDto dto) {
        return facade.placeAnOrder(id, dto);
    }

}
