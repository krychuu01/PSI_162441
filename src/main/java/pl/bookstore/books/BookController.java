package pl.bookstore.books;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.basic.ErrorListDto;
import pl.bookstore.books.dtos.BookDto;

@RequiredArgsConstructor
@RequestMapping("/api/books")
@RestController
public class BookController {

    private final BookFacade facade;

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ErrorListDto createBook(@RequestBody BookDto bookDto) {
        return facade.create(bookDto);
    }

}
