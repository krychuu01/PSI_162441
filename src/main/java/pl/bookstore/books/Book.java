package pl.bookstore.books;


import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.bookstore.books.value_objects.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Isbn isbn;
    @Embedded
    private NumberOfPages numberOfPages;
    @Embedded
    private YearOfPublication yearOfPublication;
    @Embedded
    private Publisher publisher;
    @Embedded
    private Binding binding;

    @Builder
    public Book (Isbn isbn, NumberOfPages numberOfPages, YearOfPublication yearOfPublication, Publisher publisher, Binding binding){
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
        this.binding = binding;
    }

}
