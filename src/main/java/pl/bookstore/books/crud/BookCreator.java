package pl.bookstore.books.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.MessageListDto;
import pl.bookstore.basic.exceptions.AlreadyExistException;
import pl.bookstore.basic.exceptions.DateValidationException;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.books.Book;
import pl.bookstore.books.BookRepository;

@Component
@RequiredArgsConstructor
public class BookCreator {

    private final BookRepository bookRepository;

    public MessageListDto create(EntityDto<Book> bookDto) {
        var errorList = new MessageListDto();
        saveBook(errorList, bookDto);
        return errorList;
    }

    private void saveBook(MessageListDto errorList, EntityDto<Book> bookDto) {
        try {
            var book = bookDto.toEntity();
            if (existByIsbn(book)) {
                throw new AlreadyExistException("Book with this ISBN already exsists!");
            }
            bookRepository.save(book);
            errorList.buildMessage(String.format("Added book with '%s' title", book.getTitle()));
        }
        catch (StringValidationException | DateValidationException | AlreadyExistException exception) {
            errorList.addError(exception.getMessage());
        }
    }

    private boolean existByIsbn(Book book) {
        return bookRepository.existsByIsbn(book.getIsbn());
    }

}
