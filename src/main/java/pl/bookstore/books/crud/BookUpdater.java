package pl.bookstore.books.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.EntityUtils;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.books.Book;
import pl.bookstore.books.BookRepository;

@Component
@RequiredArgsConstructor
public class BookUpdater {

    private final BookReader reader;
    private final BookRepository repository;

    public MessageListDto updateField(Long entityId, String fieldName, String value) {
        var messageList = new MessageListDto();

        try{
            var book = reader.findBook(entityId);
            changeFieldValue(book, fieldName, value);
            messageList.buildMessage(String.format("changed %s value", fieldName));
        }
        catch(StringValidationException | IllegalStateException exception) {
            messageList.addError(exception.getMessage());
        }

        return messageList;
    }

    private void changeFieldValue(Book book, String fieldName, String value) {
        var field = EntityUtils.getFieldName(fieldName, Book.class);
        book.setFieldValue(field, value);
        repository.save(book);
    }

}
