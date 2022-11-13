package pl.bookstore.users.dtos;

import lombok.Builder;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.users.User;
import pl.bookstore.users.value_objects.*;

import java.time.LocalDate;

public record UserDto(String login, String email,
                      String password, String firstName, String lastName,
                      String phoneNumber, LocalDate dateOfBirth) implements EntityDto<User> {

    @Builder
    public UserDto {}

    @Override
    public User toEntity() {
        return User.builder()
                .login(new Login(this.login()))
                .email(new Email(this.email()))
                .password(new Password(this.password()))
                .name(new Name(this.firstName(), this.lastName()))
                .phoneNumber(new PhoneNumber(this.phoneNumber()))
                .dateOfBirth(new DateOfBirth(this.dateOfBirth()))
                .build();
    }

}
