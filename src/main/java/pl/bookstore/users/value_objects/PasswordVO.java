package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.StringValidationException;
import pl.bookstore.basic.StringValidator;

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
        if (!isValid(password)) {
            throw new StringValidationException(String.format("%s must be between %d-%d characters length, and contains only alphanumeric and special signs.",
                    "Password", MIN_LENGTH, MAX_LENGTH));
        }
        this.password = password;
    }

    @Override
    public boolean isValid(Object value) {
        setValidatorData();
        return this.isValidLength() && this.isFromCorrectCharacters();
    }

    @Override
    public void setValidatorData() {
        this.setField(password);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
