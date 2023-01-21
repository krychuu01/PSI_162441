package pl.bookstore.authors.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.authors.AuthorDto;
import pl.bookstore.authors.AuthorRepository;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.users.value_objects.Name;

@Component
@RequiredArgsConstructor
public class AuthorUpdater {

    private final AuthorRepository repository;
    private final AuthorReader reader;

    public MessageListDto updateAuthorName(Long entityId, AuthorDto dto) {
        var messageList = new MessageListDto();
        try {
            var author = reader.findAuthor(entityId);
            var newAuthorName = new Name(dto.firstName(), dto.lastName());
            author.setName(newAuthorName);
            repository.save(author);
            messageList.buildMessage("Successfully changed authors name.");
        }
        catch (IllegalStateException | StringValidationException exception) {
            messageList.addError(exception.getMessage());
        }
        return messageList;
    }

}
