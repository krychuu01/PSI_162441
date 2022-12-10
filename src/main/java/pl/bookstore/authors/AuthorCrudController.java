package pl.bookstore.authors;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.basic.dto.MessageListDto;

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

}
