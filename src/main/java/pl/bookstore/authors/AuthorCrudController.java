package pl.bookstore.authors;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.interfaces.EntityDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/authors")
public class AuthorCrudController {

    private final AuthorFacade facade;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageListDto createAuthor(@RequestBody AuthorDto authorDto) {
        return facade.create(authorDto);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<EntityDto<Author>> getAllAuthors(@RequestParam(required = false) Integer page) {
        return facade.readAll(page);
    }

}
