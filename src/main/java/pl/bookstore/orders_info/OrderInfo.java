package pl.bookstore.orders_info;

import lombok.Builder;
import pl.bookstore.books.Book;
import pl.bookstore.orders.Order;

import javax.persistence.*;

@Entity
@Table(name = "orders_info")
public class OrdersInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Book book;

    private Integer booksAmount;

    private Double price;

    @Builder
    public OrdersInfo(Order order, Book book, Integer booksAmount, Double price) {
        this.order = order;
        this.book = book;
        this.booksAmount = booksAmount;
        this.price = price;
    }

}
