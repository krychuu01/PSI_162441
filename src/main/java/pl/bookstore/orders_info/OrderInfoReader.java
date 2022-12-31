package pl.bookstore.orders_info;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderInfoReader {

    private final OrderInfoRepository repository;

    public List<OrderInfo> getAllByOrderId(Long id){
        return repository.findByBook_id(id);
    }

}