package pl.bookstore.orders.dtos;

import lombok.Builder;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.orders.Order;

public record OrderDto(String status, String orderDate, Double totalPrice) {

    @Builder
    public OrderDto {}

}
