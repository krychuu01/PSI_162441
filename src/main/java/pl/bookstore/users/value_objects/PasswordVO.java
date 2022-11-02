package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class PasswordVO extends StringValidator implements Serializable {

    private static final String REGEX = "TBA";
    private static final int MIN_LENGTH = 7;
    private static final int MAX_LENGTH = 55;
    private String password;

    public PasswordVO(String password) {
        if (!isValid()) {
            throw new StringValidationException(String.format("%s must be between %d-%d characters length, and contains only alphanumeric and special signs.",
                    "Password", MIN_LENGTH, MAX_LENGTH));
        }
        this.password = password;
    }

    @Override
    public boolean isValid() {
        setValidatorData();
        return this.isValidLength() &&
               this.isFromCorrectCharacters();
    }

    private void setValidatorData() {
        this.setField(password);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
