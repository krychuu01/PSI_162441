package pl.bookstore.authors.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.authors.Author;
import pl.bookstore.authors.AuthorRepository;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.exceptions.AlreadyExistException;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.interfaces.EntityDto;

@Component
@RequiredArgsConstructor
public class AuthorCreator {

    private final AuthorRepository authorRepository;

    public MessageListDto create(EntityDto<Author> authorDto) {
        var errorList = new MessageListDto();
        saveAuthor(errorList, authorDto);
        return errorList;
    }

    private void saveAuthor(MessageListDto errorList, EntityDto<Author> authorDto) {
        try {
            var author = authorDto.toEntity();
            if (existsByName(author)) {
                throw new AlreadyExistException("Author with this name already exists!");
            }
            authorRepository.save(author);
            errorList.buildMessage(String.format("Added author: %s %s to database.", author.getFirstName(), author.getLastName()));
        }
        catch (StringValidationException | AlreadyExistException exception) {
            errorList.addError(exception.getMessage());
        }
    }

    private boolean existsByName(Author author) {
        return authorRepository.existsByName(author.getFirstName(), author.getLastName());
    }

}
