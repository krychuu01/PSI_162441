package pl.bookstore.users;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO fromUserToUserDTO(User user){
        return UserDTO.builder()
                .login(user.getLogin())
                .email(user.getEmail())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .dateOfBirth(user.getDateOfBirth())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

}
