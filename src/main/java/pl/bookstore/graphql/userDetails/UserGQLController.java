package pl.bookstore.graphql.userDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserGQLController {

    private final UserGQLService userGQLService;

    @QueryMapping
    public List<UserGQL> findAllUsers() {
        return userGQLService.findAllUsers();
    }

    @QueryMapping
    public UserGQL findUserById(@Argument Long id) {
        return userGQLService.findUserById(id);
    }

    @QueryMapping
    public List<UserGQL> findUsersByCountry(@Argument String country) {
        return userGQLService.findUsersByCountry(country);
    }

    @QueryMapping
    public List<UserGQL> findUsersByCity(@Argument String city) {
        return userGQLService.findUsersByCity(city);
    }

    @QueryMapping
    public List<UserGQL> findUsersByFirstName(@Argument String firstName) {
        return userGQLService.findUsersByFirstName(firstName);
    }

    @MutationMapping
    public UserGQL addUser(@Argument UserGQL user) {
        return userGQLService.addUser(user);
    }

    @MutationMapping
    public UserGQL changeUserEmail(@Argument Long id, @Argument String email) {
        return userGQLService.changeUserEmail(id, email);
    }

    @MutationMapping
    public Long deleteUserById(@Argument Long id) {
        return userGQLService.deleteUserById(id);
    }

}
