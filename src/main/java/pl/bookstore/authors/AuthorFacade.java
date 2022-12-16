package pl.bookstore.authors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.authors.crud.AuthorCreator;
import pl.bookstore.authors.crud.AuthorDeleter;
import pl.bookstore.authors.crud.AuthorReader;
import pl.bookstore.authors.crud.AuthorUpdater;
import pl.bookstore.basic.SortDirection;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.dto.UpdateDto;
import pl.bookstore.basic.interfaces.CrudInterface;
import pl.bookstore.basic.interfaces.EntityDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorFacade implements CrudInterface<Author> {

    private final AuthorCreator creator;
    private final AuthorReader reader;
    private final AuthorUpdater updater;
    private final AuthorDeleter deleter;

    @Override
    public MessageListDto create(EntityDto<Author> entityDto) {
        return creator.create(entityDto);
    }

    @Override
    public EntityDto<Author> readOne(Long id) {
        return null;
    }

    @Override
    public List<? extends EntityDto<Author>> readAll(Integer pageNumber, Integer pageSize, String fieldName, SortDirection sortDirection) {
        return reader.getAllAuthors(pageNumber, pageSize, fieldName, sortDirection);
    }

    @Override
    public MessageListDto updateField(Long entityId, UpdateDto dto) {
        return null;
    }

    @Override
    public MessageListDto delete(Long entityId) {
        return null;
    }

}
