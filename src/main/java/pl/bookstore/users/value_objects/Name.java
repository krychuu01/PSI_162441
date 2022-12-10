package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class Name extends StringValidator implements Serializable {

    public static final String REGEX = "[\\p{Alpha}\\p{Space}-.']++";
    public static final int MIN_LENGTH = 3;
    public static final int MAX_LENGTH = 30;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "last_name")
    public String lastName;

    public Name(String firstName, String lastName) {
        setValidatorData(firstName);
        if (!isValid()) {
            throw new StringValidationException(String.format("%s must be between %d-%d characters length, and contains alphanumeric signs.",
                    "First name", MIN_LENGTH, MAX_LENGTH));
        }
        setValidatorData(lastName);
        if (!isValid()) {
            throw new StringValidationException(String.format("%s must be between %d-%d characters length, and contains alphanumeric signs.",
                    "Last name", MIN_LENGTH, MAX_LENGTH));
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public boolean isValid() {
        return this.isLengthBetweenTwoValues() &&
               this.isFromCorrectCharacters();
    }

    private void setValidatorData(String name) {
        this.setField(name);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
