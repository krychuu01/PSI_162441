package pl.bookstore.books.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.books.BookRepository;

@Component
@RequiredArgsConstructor
public class BookDeleter {

    private final BookReader reader;
    private final BookRepository repository;

    public MessageListDto deleteById(Long entityId) {
        var messageList = new MessageListDto();

        try{
            var book = reader.findBook(entityId);
            repository.deleteById(entityId);
            messageList.buildMessage(String.format("deleted %s book", book.getTitle()));
        }
        catch (Exception exception) {
            messageList.addError("Cannot find book with given id");
        }

        return messageList;
    }

}
