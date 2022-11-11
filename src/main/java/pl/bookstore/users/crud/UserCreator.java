package pl.bookstore.users.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.ErrorListDto;
import pl.bookstore.basic.exceptions.DateValidationException;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.users.UserMapper;
import pl.bookstore.users.UserRepository;
import pl.bookstore.users.dtos.UserDto;

import java.util.ArrayList;

@RequiredArgsConstructor
@Component
public class UserCreator {

    private final UserRepository repository;
    private final UserMapper mapper;

    public ErrorListDto create(UserDto userDto) {
        var errorList = new ErrorListDto(new ArrayList<>());
        saveUser(errorList, userDto);
        errorList.buildMessage(String.format("Added user with %s email", userDto.email()));
        return errorList;
    }

    private void saveUser(ErrorListDto errorList, UserDto userDto) {
        try {
            var user = mapper.fromUserDtoToUser(userDto);
            repository.save(user);
        }
        catch (StringValidationException | DateValidationException exception) {
            errorList.addError(exception.getMessage());
        }
    }

}
