package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.StringValidator;
import pl.bookstore.basic.StringValidationException;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class LoginVO implements StringValidator {

    public static final String REGEX = "TBA";
    public static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 20;
    public String login;

    public LoginVO(String login) {
        if (!isValid(login, MIN_LENGTH, MAX_LENGTH, REGEX)) {
            throw new StringValidationException("Login", MIN_LENGTH, MAX_LENGTH, "upper and lower case letters, numbers and special characters.");
        }
        this.login = login;
    }

}
