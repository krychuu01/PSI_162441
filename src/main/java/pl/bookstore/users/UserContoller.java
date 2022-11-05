package pl.bookstore.users;

import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserContoller {

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable Long id){
        throw new IllegalArgumentException("Not implemented yet!");
    }

    @GetMapping("/spring")
    public String getSpring(){
        return SpringVersion.getVersion();
    }

}
