package pl.bookstore.orders_info;

import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.bookstore.books.Book;
import pl.bookstore.orders.Order;

import javax.persistence.*;

@Entity
@Table(name = "orders_info")
@NoArgsConstructor
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

    public OrderInfoDto toDto() {
        return OrderInfoDto.builder()
                .bookTitle(this.book.getTitle())
                .coverType(this.book.getBinding().getCoverType())
                .yearOfPublication(this.book.getYearOfPublication())
                .singleBookPrice(this.book.getPrice())
                .booksAmount(this.getBooksAmount())
                .price(this.getPrice())
                .build();
    }

    public Double getPrice() {
        return this.price;
    }

    public Book getBook() {
        return this.book;
    }

    public Integer getBooksAmount() {
        return this.booksAmount;
    }

}
