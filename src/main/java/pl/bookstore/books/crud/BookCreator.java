package pl.bookstore.books.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.ErrorListDto;
import pl.bookstore.books.BookRepository;
import pl.bookstore.books.dtos.BookDto;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class BookCreator {

    private final BookRepository repository;

    public ErrorListDto create(BookDto bookDto) {
        var errorList = new ErrorListDto(new ArrayList<>());
        saveBook(bookDto);
//        errorList.buildMessage(String.format("Book %s successfully added", bookDto.title()));
        return errorList;
    }

    private void saveBook(BookDto bookDto) {

    }

}
