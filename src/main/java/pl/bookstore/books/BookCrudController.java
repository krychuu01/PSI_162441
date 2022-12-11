package pl.bookstore.books;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.dto.UpdateDto;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.books.dtos.BookDto;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/books")
@RestController
public class BookCrudController {

    private final BookFacade facade;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageListDto createBook(@RequestBody BookDto bookDto) {
        return facade.create(bookDto);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<? extends EntityDto<Book>> getBooks(@RequestParam int page) {
        return facade.readAll(page);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityDto<Book> getBook(@PathVariable Long id) {
        return facade.readOne(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MessageListDto editBookField(@PathVariable Long id, @RequestBody UpdateDto dto) {
        return facade.updateField(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageListDto deleteBook(@PathVariable Long id) {
        return facade.delete(id);
    }

}
