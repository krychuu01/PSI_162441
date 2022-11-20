package pl.bookstore.orders.dtos;

import lombok.Builder;

public record OrderDto(String status, String orderDate, Double totalPrice) {

    @Builder
    public OrderDto {}

}
