package pl.bookstore.books.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.books.Book;
import pl.bookstore.books.BookRepository;

import java.lang.reflect.Field;

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
        var field = getFieldName(fieldName);
        book.setFieldValue(field, value);
        repository.save(book);
    }

    private String getFieldName(String fieldName) {
        for (Field fieldname : Book.class.getDeclaredFields()) {
            if (fieldname.getName().equals(fieldName)) {
                return fieldname.getName();
            }
        }
        throw new IllegalStateException(String.format("Field name %s not found", fieldName));
    }

}
