package pl.bookstore.users;

import lombok.Builder;

import java.time.LocalDate;

public record UserDTO (String login, String email,
                       String password, String firstName, String lastName,
                       String phoneNumber, LocalDate dateOfBirth){

    @Builder
    public UserDTO {}
}
