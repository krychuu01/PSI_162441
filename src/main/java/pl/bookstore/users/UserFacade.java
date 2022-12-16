package pl.bookstore.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.SortDirection;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.dto.UpdateDto;
import pl.bookstore.basic.interfaces.CrudInterface;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.users.crud.UserCreator;
import pl.bookstore.users.crud.UserDeleter;
import pl.bookstore.users.crud.UserReader;
import pl.bookstore.users.crud.UserUpdater;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserFacade implements CrudInterface<User> {

    private final UserCreator creator;
    private final UserReader reader;
    private final UserUpdater updater;
    private final UserDeleter deleter;

    @Override
    public MessageListDto create(EntityDto<User> entityDto) {
        return creator.create(entityDto);
    }

    @Override
    public EntityDto<User> readOne(Long id) {
        return reader.getUserAsDtoById(id);
    }

    @Override
    public List<? extends EntityDto<User>> readAll(Integer pageNumber, Integer pageSize, String fieldName, SortDirection sortDirection) {
        return reader.getAllUsers(pageNumber, pageSize, fieldName, sortDirection);
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
