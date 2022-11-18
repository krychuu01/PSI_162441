package pl.bookstore.books;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.basic.MessageListDto;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.books.dtos.BookDto;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/books")
@RestController
public class BookController {

    private final BookFacade facade;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageListDto createBook(@RequestBody BookDto bookDto) {
        return facade.create(bookDto);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<EntityDto<Book>> getBooks() {
        return facade.readAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityDto<Book> getBook(@PathVariable Long id) {
        return facade.readOne(id);
    }

}
