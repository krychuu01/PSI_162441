package pl.bookstore.orders.value_objects;

import java.util.Objects;
import java.util.stream.Stream;

public enum Status {

    PENDING("pending"),
    PAID("paid"),
    SHIPPED("shipped");

    private final String orderStatus;

    Status(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public static Status getStatus(String orderStatus) {
        return Stream.of(values())
                .filter(status -> status.orderStatus.equals(orderStatus))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Order status must be one of '%s', '%s' or '%s'",
                        Status.PAID, Status.PENDING, Status.SHIPPED)));
    }

    public boolean isPending() {
        return Objects.equals(this.orderStatus, PENDING.getOrderStatus());
    }

    public boolean isPaid() {
        return Objects.equals(this.orderStatus, PAID.getOrderStatus());
    }

    public boolean isShipped() {
        return Objects.equals(this.orderStatus, SHIPPED.getOrderStatus());
    }

}
