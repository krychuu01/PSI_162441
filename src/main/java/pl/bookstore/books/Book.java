package pl.bookstore.books;


import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.bookstore.basic.interfaces.EntityMapper;
import pl.bookstore.books.dtos.BookDto;
import pl.bookstore.books.value_objects.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book implements Serializable, EntityMapper<BookDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Isbn isbn;
    @Embedded
    private Title title;
    @Embedded
    private NumberOfPages numberOfPages;
    @Embedded
    private YearOfPublication yearOfPublication;
    @Embedded
    private Publisher publisher;

    @Embedded
    private Price price;
    @Enumerated(EnumType.STRING)
    private Binding binding;

    @Builder
    public Book (Isbn isbn, Title title, NumberOfPages numberOfPages, YearOfPublication yearOfPublication, Publisher publisher, Price price, Binding binding){
        this.isbn = isbn;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
        this.price = price;
        this.binding = binding;
    }

    @Override
    public BookDto toDto() {
        return BookDto.builder()
                .id(this.getId())
                .isbn(this.getIsbn())
                .title(this.getTitle())
                .numberOfPages(this.getNumberOfPages())
                .yearOfPublication(this.getYearOfPublication())
                .publisher(this.getPublisher())
                .price(this.getPrice())
                .coverType(this.binding.getCoverType())
                .build();
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn.isbn;
    }

    public String getTitle(){
        return title.title;
    }

    public String getNumberOfPages() {
        return numberOfPages.numberOfPages;
    }

    public String getYearOfPublication() {
        return yearOfPublication.yearOfPublication;
    }

    public String getPublisher() {
        return publisher.publisher;
    }

    public Double getPrice() {
        return price.price;
    }
    public Binding getBinding() {
        return binding;
    }

    public void setFieldValue(String fieldName, String value){
        switch (fieldName) {
            case "isbn" -> this.isbn = new Isbn(value);
            case "title" -> this.title = new Title(value);
            case "numberOfPages" -> this.numberOfPages = new NumberOfPages(value);
            case "yearOfPublication" -> this.yearOfPublication = new YearOfPublication(value);
            case "publisher" -> this.publisher = new Publisher(value);
            case "binding" -> this.binding = Binding.getBindingType(value);
            default -> throw new IllegalStateException("Field not found or can't be changed.");
        }
    }

}
