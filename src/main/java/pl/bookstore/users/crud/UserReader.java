package pl.bookstore.users.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.users.User;
import pl.bookstore.users.UserMapper;
import pl.bookstore.users.UserRepository;
import pl.bookstore.users.dtos.UserDto;

@RequiredArgsConstructor
@Component
public class UserReader {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserDto getUserById(Long id) {
        var user = findUser(id);
        return mapper.fromUserToUserDto(user);
    }

    public User findUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException(""));
    }

}
