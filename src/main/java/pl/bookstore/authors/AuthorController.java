package pl.bookstore.authors;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.basic.SortDirection;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.dto.UpdateDto;
import pl.bookstore.basic.interfaces.EntityDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorFacade facade;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageListDto createAuthor(@RequestBody AuthorDto authorDto) {
        return facade.create(authorDto);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<? extends EntityDto<Author>> getAllAuthors(@RequestParam(required = false) Integer pageNumber,
                                                           @RequestParam(required = false) Integer pageSize,
                                                           @RequestParam AuthorFields fieldName,
                                                           @RequestParam SortDirection sortDirection) {
        return facade.readAll(pageNumber, pageSize, fieldName.getFieldName(), sortDirection);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public EntityDto<Author> getAuthorById(@PathVariable Long id) {
        return facade.readOne(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageListDto updateAuthorField(@PathVariable Long id, @RequestBody AuthorDto dto) {
        return facade.updateAuthorName(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MessageListDto deleteAuthorById(@PathVariable Long id) {
        return facade.delete(id);
    }

}
