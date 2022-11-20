package pl.bookstore.orders_info;

import lombok.Builder;
import pl.bookstore.books.Book;
import pl.bookstore.orders.Order;

import javax.persistence.*;

@Entity
@Table(name = "orders_info")
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "books_id")
    private Book book;

    private Integer booksAmount;

    private Double price;

    @Builder
    public OrderInfo(Order order, Book book, Integer booksAmount, Double price) {
        this.order = order;
        this.book = book;
        this.booksAmount = booksAmount;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

}
