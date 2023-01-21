package pl.bookstore.authors.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.authors.AuthorRepository;
import pl.bookstore.basic.dto.MessageListDto;

@Component
@RequiredArgsConstructor
public class AuthorDeleter {

    private final AuthorRepository repository;
    private final AuthorReader reader;
    public MessageListDto deleteAuthor(Long entityId) {
        var messageList = new MessageListDto();
        try {
            var author = reader.findAuthor(entityId);
            repository.delete(author);
            messageList.buildMessage(String.format("Deleted author: %s %s from database.", author.getFirstName(), author.getLastName()));
        }
        catch (IllegalStateException exception) {
            messageList.addError(exception.getMessage());
        }
        return messageList;
    }

}
