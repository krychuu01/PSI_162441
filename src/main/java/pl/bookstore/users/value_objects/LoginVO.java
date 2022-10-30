package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.StringValidator;
import pl.bookstore.basic.ValidationException;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class LoginVO implements StringValidator {

    public static final String REGEX = "^[A-Za-z0-9]+([A-Za-z0-9]*|[._-]?[A-Za-z0-9]+)*$";
    public static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 20;
    public String login;

    public LoginVO(String login) {
        if (!isValid(login, MIN_LENGTH, MAX_LENGTH, REGEX)) {
            throw new ValidationException("Login", MIN_LENGTH, MAX_LENGTH, REGEX);
        }
        this.login = login;
    }

}
