package pl.bookstore.users.value_objects;

import pl.bookstore.basic.StringValidationException;
import pl.bookstore.basic.Validator;

import java.io.Serializable;

public class EmailVO extends Validator implements Serializable {

    public static final String REGEX = "TBA";
    public static final int MIN_LENGTH = 7;
    public static final int MAX_LENGTH = 55;
    public String email;

    public EmailVO(String email) {
        if (!isValid(email)) {
            throw new StringValidationException("Email", MIN_LENGTH, MAX_LENGTH,
                    "upper and lower case letters, numbers, one @ sign and dots.");
        }
        this.email = email;
    }

    @Override
    public boolean isValid(Object value) {
        setValidatorData();
        return this.isValidLength() && this.containsValidCharacters();
    }

    @Override
    public void setValidatorData() {
        this.setField(email);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
