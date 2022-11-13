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
    @Enumerated(EnumType.STRING)
    private Binding binding;

    @Builder
    public Book (Isbn isbn, Title title, NumberOfPages numberOfPages, YearOfPublication yearOfPublication, Publisher publisher, Binding binding){
        this.isbn = isbn;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
        this.binding = binding;
    }

    @Override
    public BookDto toDto() {
        return BookDto.builder()
                .isbn(this.getIsbn())
                .title(this.getTitle())
                .numberOfPages(this.getNumberOfPages())
                .yearOfPublication(this.getYearOfPublication())
                .publisher(this.getPublisher())
                .coverType(this.binding.getCoverType())
                .build();
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

    public Binding getBinding() {
        return binding;
    }

}
