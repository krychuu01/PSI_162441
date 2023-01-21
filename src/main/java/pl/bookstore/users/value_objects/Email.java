package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class Email extends StringValidator implements Serializable {

    private static final String REGEX = "[\\p{Alpha}\\p{Digit}]++@[\\p{Alpha}\\p{Digit}]++.[\\p{Alpha}\\p{Digit}]++";
    private static final int MIN_LENGTH = 7;
    private static final int MAX_LENGTH = 55;
    public String email;

    public Email(String email) {
        setValidatorData(email);
        if (!isValid()) {
            throw new StringValidationException(String.format("%s must be between %d-%d characters length, and contains only %s",
                    "Email", MIN_LENGTH, MAX_LENGTH, "letters, digits, one '@' sign and dots!"));
        }
        this.email = email;
    }

    @Override
    public boolean isValid() {
        return this.isLengthBetweenTwoValues() &&
               this.isFromCorrectCharacters();
    }

    protected void setValidatorData(String email) {
        this.setField(email);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
