package pl.bookstore.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.basic.ErrorListDto;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.users.dtos.UserDto;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserContoller {

    private final UserFacade facade;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityDto<User> getUser(@PathVariable Long id){
        return facade.readOne(id);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<EntityDto<User>> getUsers() {
        return facade.readAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ErrorListDto createUser(@RequestBody UserDto userDto){
        return facade.create(userDto);
    }


}


