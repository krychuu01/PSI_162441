package pl.bookstore.orders;


import pl.bookstore.basic.interfaces.EntityMapper;
import pl.bookstore.orders.dtos.OrderDto;
import pl.bookstore.orders.value_objects.Status;
import pl.bookstore.orders.value_objects.TotalPrice;
import pl.bookstore.users.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "orders")
public class Order implements EntityMapper<OrderDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime orderDate;

    @Embedded
    @Column(name = "total_price")
    private TotalPrice totalPrice;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    public Order() {
        this.status = Status.PENDING;
        this.orderDate = LocalDateTime.now();
        this.totalPrice = new TotalPrice();
    }

    @Override
    public OrderDto toDto() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return OrderDto.builder()
                .status(this.getStatus())
                .totalPrice(this.getTotalPrice())
                .orderDate(dtf.format(this.getOrderDate()))
                .build();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void changeStatus(String orderStatus) {
        this.status = Status.getStatus(orderStatus);
    }

    public String getStatus() {
        return this.status.getOrderStatus();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    public Double getTotalPrice() {
        return this.totalPrice.totalPrice;
    }

    public void addValueToTotalPrice(Double price) {
        this.totalPrice.add(price);
    }

}
