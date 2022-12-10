package pl.bookstore.books_has_authors;


import lombok.NoArgsConstructor;
import pl.bookstore.authors.Author;
import pl.bookstore.basic.interfaces.EntityMapper;
import pl.bookstore.books.Book;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books_has_authors")
@NoArgsConstructor
public class BooksHasAuthor implements Serializable, EntityMapper<BooksHasAuthorDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Author author;

    public BooksHasAuthor(Book book, Author author) {
        this.book = book;
        this.author = author;
    }

    @Override
    public BooksHasAuthorDto toDto() {
        return null;
    }

}
