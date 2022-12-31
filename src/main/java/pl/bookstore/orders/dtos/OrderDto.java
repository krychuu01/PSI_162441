package pl.bookstore.orders.dtos;

import lombok.Builder;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.orders.Order;
import pl.bookstore.orders_info.OrderInfoDto;

import java.util.List;

public record OrderDto(Long id, String status, String orderDate, Double totalPrice, List<OrderInfoDto> orderInfos) implements EntityDto<Order> {

    @Builder
    public OrderDto {}

    @Override
    public Order toEntity() {
        return null;
    }
}
