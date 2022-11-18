package pl.bookstore.books;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.MessageListDto;
import pl.bookstore.basic.interfaces.CrudInterface;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.books.crud.BookCreator;
import pl.bookstore.books.crud.BookDeleter;
import pl.bookstore.books.crud.BookReader;
import pl.bookstore.books.crud.BookUpdater;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookFacade implements CrudInterface<Book> {

    private final BookCreator creator;
    private final BookReader reader;
    private final BookUpdater updater;
    private final BookDeleter deleter;


    @Override
    public MessageListDto create(EntityDto<Book> entityDto) {
        return creator.create(entityDto);
    }

    @Override
    public EntityDto<Book> readOne(Long id) {
        return reader.getBookById(id);
    }

    @Override
    public List<EntityDto<Book>> readAll() {
        return reader.getAllBooks();
    }

    @Override
    public MessageListDto updateField(Long entityId, EntityDto<Book> entityDto, String fieldName) {
        return null;
    }

    @Override
    public MessageListDto delete(Long entityId) {
        return null;
    }
}
