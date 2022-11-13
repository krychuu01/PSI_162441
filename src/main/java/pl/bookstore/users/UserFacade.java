package pl.bookstore.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.ErrorListDto;
import pl.bookstore.basic.interfaces.CrudInterface;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.users.crud.UserCreator;
import pl.bookstore.users.crud.UserDeleter;
import pl.bookstore.users.crud.UserReader;
import pl.bookstore.users.crud.UserUpdater;
import pl.bookstore.users.dtos.UserDto;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserFacade implements CrudInterface<User> {

    private final UserCreator creator;
    private final UserReader reader;
    private final UserUpdater updater;
    private final UserDeleter deleter;

    @Override
    public ErrorListDto create(EntityDto<User> entityDto) {
        return creator.create(entityDto);
    }

    @Override
    public EntityDto<User> readOne(Long entityId) {
        return reader.getUserById(entityId);
    }

    @Override
    public List<EntityDto<User>> readAll() {
        return reader.getAllUsers();
    }

    @Override
    public ErrorListDto updateField(Long entityId, EntityDto<User> entityDto, String fieldName) {
        return null;
    }

    @Override
    public ErrorListDto delete(Long entityId) {
        return null;
    }

}
