package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class EmailVO extends StringValidator implements Serializable {

    private static final String REGEX = "TBA";
    private static final int MIN_LENGTH = 7;
    private static final int MAX_LENGTH = 55;
    private String email;

    public EmailVO(String email) {
        setValidatorData(email);
        if (!isValid()) {
            throw new StringValidationException(String.format("%s must be between %d-%d characters length, and contains only %s",
                    "Email", MIN_LENGTH, MAX_LENGTH, REGEX));
        }
        this.email = email;
    }

    @Override
    public boolean isValid() {
        return this.isValidLength() &&
               this.isFromCorrectCharacters();
    }

    protected void setValidatorData(String email) {
        this.setField(email);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
