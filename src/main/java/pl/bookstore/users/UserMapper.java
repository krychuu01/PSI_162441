package pl.bookstore.users;

import org.springframework.stereotype.Component;
import pl.bookstore.users.dtos.UserDto;
import pl.bookstore.users.value_objects.*;

@Component
public class UserMapper {

    public UserDto fromUserToUserDto(User user) {
        return UserDto.builder()
                .login(user.getLogin())
                .email(user.getEmail())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .dateOfBirth(user.getDateOfBirth())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public User fromUserDtoToUser(UserDto userDTO) {
        return User.builder()
                .login(new Login(userDTO.login()))
                .email(new Email(userDTO.email()))
                .password(new Password(userDTO.password()))
                .name(new Name(userDTO.firstName(), userDTO.lastName()))
                .phoneNumber(new PhoneNumber(userDTO.phoneNumber()))
                .dateOfBirth(new DateOfBirth(userDTO.dateOfBirth()))
                .build();
    }

}
