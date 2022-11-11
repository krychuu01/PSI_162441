package pl.bookstore.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.ErrorListDto;
import pl.bookstore.users.crud.UserCreator;
import pl.bookstore.users.crud.UserDeleter;
import pl.bookstore.users.crud.UserReader;
import pl.bookstore.users.crud.UserUpdater;
import pl.bookstore.users.dtos.UserDto;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserCreator creator;
    private final UserReader reader;
    private final UserUpdater updater;
    private final UserDeleter deleter;

    public UserDto getUserById(Long id){
        return reader.getUserById(id);
    }

    public List<UserDto> getAllUsers() {
        return reader.getAllUsers();
    }

    public ErrorListDto createUser(UserDto userDto){
        return creator.create(userDto);
    }
}
