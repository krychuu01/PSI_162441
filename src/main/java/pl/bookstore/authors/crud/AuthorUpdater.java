package pl.bookstore.authors.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.authors.Author;
import pl.bookstore.authors.AuthorRepository;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.exceptions.StringValidationException;

import static pl.bookstore.users.value_objects.Name.*;

@Component
@RequiredArgsConstructor
public class AuthorUpdater {

    private final AuthorRepository repository;
    private final AuthorReader reader;

    public MessageListDto updateField(Long entityId, String fieldName, String value) {
        var messageList = new MessageListDto();

        try {
            var author = reader.findAuthor(entityId);
            changeFieldValue(author, fieldName, value);
            messageList.buildMessage(String.format("changed %s value", fieldName));
        }
        catch(StringValidationException | IllegalArgumentException | IllegalStateException exception) {
            messageList.addError(exception.getMessage());
        }
        return messageList;
    }

    private void changeFieldValue(Author author, String fieldName, String value) {
        if(!isValid(value)) {
            throw new StringValidationException(String.format("%s must be between %d-%d characters length, and contains alphanumeric signs.",
                    "First name", MIN_LENGTH, MAX_LENGTH));
        }
        if (fieldName.startsWith("first")) {
            author.setFirstName(value);
        }
        else if (fieldName.startsWith("last")) {
            author.setLastName(value);
        }
        else {
            throw new IllegalStateException(String.format("Field name %s not found", fieldName));
        }
        repository.save(author);
    }

    private boolean isValid(String value) {
        return value.length() >= 3 && value.length() <= 30 && value.matches(REGEX);
    }

}
