package pl.bookstore.users.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import pl.bookstore.basic.ReaderClassesUtils;
import pl.bookstore.basic.SortDirection;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.users.User;
import pl.bookstore.users.UserRepository;
import pl.bookstore.users.dtos.UserDto;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserReader {

    private final UserRepository repository;

    public List<? extends EntityDto<User>> getAllUsers(Integer pageNumber, Integer pageSize, String fieldName, SortDirection sortDirection) {
        var users = ReaderClassesUtils.getEntitiesSortedByField(repository, pageNumber, pageSize, fieldName, sortDirection);
        return ReaderClassesUtils.getDtoList(users);
    }

    public UserDto getUserAsDtoById(Long id) {
        var user = findUser(id);
        return user.toDto();
    }

    public User findUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User not found"));
    }

}
