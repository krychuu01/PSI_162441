package pl.bookstore.users.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.users.User;
import pl.bookstore.users.UserRepository;
import pl.bookstore.users.dtos.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserReader {

    private final UserRepository repository;

    public UserDto getUserById(Long id) {
        var user = findUser(id);
        return user.toDto();
    }

    public List<EntityDto<User>> getAllUsers() {
        var users = repository.findAll();
        return users.stream()
                .map(User::toDto)
                .collect(Collectors.toList());
    }

    private User findUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User not found"));
    }

}
