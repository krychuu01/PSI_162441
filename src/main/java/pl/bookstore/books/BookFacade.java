package pl.bookstore.books;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.dto.UpdateDto;
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
        return reader.getBookDtoById(id);
    }

    @Override
    public List<EntityDto<Book>> readAll(Integer page) {
        return reader.getAllBooks(page);
    }

    @Override
    public MessageListDto updateField(Long entityId, UpdateDto dto) {
        return updater.updateField(entityId, dto.fieldName(), dto.value());
    }

    @Override
    public MessageListDto delete(Long entityId) {
        return deleter.deleteById(entityId);
    }

}
