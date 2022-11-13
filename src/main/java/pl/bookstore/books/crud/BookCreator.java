package pl.bookstore.books.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.ErrorListDto;
import pl.bookstore.basic.exceptions.AlreadyExistException;
import pl.bookstore.basic.exceptions.DateValidationException;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.books.Book;
import pl.bookstore.books.BookRepository;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class BookCreator {

    private final BookRepository bookRepository;

    public ErrorListDto create(EntityDto<Book> bookDto) {
        var errorList = new ErrorListDto(new ArrayList<>());
//        saveBook(errorList, bookDto);
//        errorList.buildMessage(String.format("Book %s successfully added", bookDto.title()));
        return errorList;
    }

//    private void saveBook(ErrorListDto errorList, EntityDto<Book> bookDto) {
//        try {
//            var book = bookDto.toEntity();
//            if (existByTitle(book)) {
//                throw new AlreadyExistException("user");
//            }
//            bookRepository.save(book);
//            errorList.buildMessage(String.format("Added book with %s title", book.getTitle()));
//        }
//        catch (StringValidationException | DateValidationException | AlreadyExistException exception) {
//            errorList.addError(exception.getMessage());
//        }
//    }
//
//    private boolean existByTitle(Book book) {
//        return bookRepository.existsByTitle(book.getTitle());
//    }

}
