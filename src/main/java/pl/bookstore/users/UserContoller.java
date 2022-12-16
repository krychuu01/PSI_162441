package pl.bookstore.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.basic.SortDirection;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.users.dtos.UserDto;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserContoller {

    private final UserFacade facade;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageListDto createUser(@RequestBody UserDto userDto){
        return facade.create(userDto);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<? extends EntityDto<User>> getUsers(@RequestParam(required = false) Integer pageNumber,
                                                    @RequestParam(required = false) Integer pageSize,
                                                    @RequestParam(required = false) String fieldName,
                                                    @RequestParam SortDirection sortDirection) {
        return facade.readAll(pageNumber, pageSize, fieldName, sortDirection);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityDto<User> getUser(@PathVariable Long id){
        return facade.readOne(id);
    }


}


