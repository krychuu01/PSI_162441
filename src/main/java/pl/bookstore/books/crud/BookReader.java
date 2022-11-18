package pl.bookstore.books.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.books.Book;
import pl.bookstore.books.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookReader {

    private final BookRepository repository;

    public List<EntityDto<Book>> getAllBooks() {
        var books = repository.findAll();
        return books.stream()
                .map(Book::toDto)
                .collect(Collectors.toList());
    }

    public EntityDto<Book> getBookById(Long id) {
        var book = findBook(id);
        return book.toDto();
    }

    private Book findBook(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Book not found"));
    }

}
