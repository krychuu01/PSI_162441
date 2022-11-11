package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class Password extends StringValidator implements Serializable {

    private static final String REGEX = "TBA";
    private static final int MIN_LENGTH = 7;
    private static final int MAX_LENGTH = 55;
    public String password;

    public Password(String password) {
        setValidatorData(password);
        if (!isValid()) {
            throw new StringValidationException(String.format("%s must be between %d-%d characters length, and contains only alphanumeric and special signs.",
                    "Password", MIN_LENGTH, MAX_LENGTH));
        }
        this.password = password;
    }

    @Override
    public boolean isValid() {
        return this.isValidLength() &&
               this.isFromCorrectCharacters();
    }

    private void setValidatorData(String password) {
        this.setField(password);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
