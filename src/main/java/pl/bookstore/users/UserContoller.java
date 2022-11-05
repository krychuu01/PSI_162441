package pl.bookstore.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserContoller {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUser(@PathVariable Long id){
        var user = userRepository.findUserById(id);
        return userMapper.fromUserToUserDTO(user);
    }


}


