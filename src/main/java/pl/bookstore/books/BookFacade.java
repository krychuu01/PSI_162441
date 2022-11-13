package pl.bookstore.books;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.ErrorListDto;
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
    public ErrorListDto create(EntityDto<Book> entityDto) {
        return null;
    }

    @Override
    public EntityDto<Book> readOne(Long entityId) {
        return null;
    }

    @Override
    public List<EntityDto<Book>> readAll() {
        return null;
    }

    @Override
    public ErrorListDto updateField(Long entityId, EntityDto<Book> entityDto, String fieldName) {
        return null;
    }

    @Override
    public ErrorListDto delete(Long entityId) {
        return null;
    }
}
