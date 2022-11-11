package pl.bookstore.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.basic.ErrorListDto;
import pl.bookstore.users.dtos.UserDto;


@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserContoller {

    private final UserFacade facade;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable Long id){
        return facade.getUserById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ErrorListDto createUser(@RequestBody UserDto userDto){
        return facade.createUser(userDto);
    }


}


