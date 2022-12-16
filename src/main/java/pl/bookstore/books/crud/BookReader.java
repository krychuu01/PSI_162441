package pl.bookstore.books.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.ReaderClassesUtils;
import pl.bookstore.basic.SortDirection;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.books.Book;
import pl.bookstore.books.BookRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookReader {

    private final BookRepository repository;

    public List<? extends EntityDto<Book>> getAllBooks(Integer pageNumber, Integer pageSize, String fieldName, SortDirection sortDirection) {
        var books = ReaderClassesUtils.getEntitiesSortedByField(repository, pageNumber, pageSize, fieldName, sortDirection);
        return ReaderClassesUtils.getDtoList(books);
    }

    public EntityDto<Book> getBookDtoById(Long id) {
        var book = findBook(id);
        return book.toDto();
    }

    protected Book findBook(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Book not found"));
    }

}
