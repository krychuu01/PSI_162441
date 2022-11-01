package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.StringValidator;
import pl.bookstore.basic.StringValidationException;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class NameVO extends StringValidator {

    public static final String REGEX = "[\\p{Alpha}\\p{Space}-']++";
    public static final int MIN_LENGTH = 3;
    public static final int MAX_LENGTH = 30;
    public String name;

    public NameVO(String name) {
        if (isValid(name)) {
            throw new StringValidationException(String.format("%s must be between %d-%d characters length, and contains alphanumeric signs.",
                    "Name", MIN_LENGTH, MAX_LENGTH));
        }
        this.name = name;
    }


    @Override
    public boolean isValid(Object value) {
        return this.isValidLength() && this.isFromCorrectCharacters();
    }

    @Override
    public void setValidatorData() {
        this.setField(name);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
