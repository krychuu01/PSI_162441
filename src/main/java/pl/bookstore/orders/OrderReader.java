package pl.bookstore.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.ReaderClassesUtils;
import pl.bookstore.basic.interfaces.EntityDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderReader {

    private final OrderRepository orderRepository;

    public Order getReferenceById(Long id) {
        return orderRepository.getReferenceById(id);
    }

    public List<? extends EntityDto<Order>> getUserOrders(Long userId) {
        var orders = orderRepository.findByUser_id(userId);
        return ReaderClassesUtils.getDtoList(orders);
    }

}
