package pl.bookstore.users.value_objects;

import pl.bookstore.basic.StringValidationException;
import pl.bookstore.basic.StringValidator;

public class EmailVO implements StringValidator {

    public String email;
    public static final int MIN_LENGTH = 7;
    public static final int MAX_LENGTH = 55;
    public static final String REGEX = "TBA";

    public EmailVO(String email) {
        if (!isValid(email, MIN_LENGTH, MAX_LENGTH, REGEX)) {
            throw new StringValidationException("Email", MIN_LENGTH, MAX_LENGTH, "upper and lower case letters, numbers, one @ sign and dots.");
        }
        this.email = email;
    }

}
