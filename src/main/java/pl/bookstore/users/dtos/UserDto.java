package pl.bookstore.users.dtos;

import lombok.Builder;

import java.time.LocalDate;

public record UserDto(String login, String email,
                      String password, String firstName, String lastName,
                      String phoneNumber, LocalDate dateOfBirth){

    @Builder
    public UserDto {}
}
