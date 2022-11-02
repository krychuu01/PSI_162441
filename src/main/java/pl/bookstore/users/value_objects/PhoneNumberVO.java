package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class PhoneNumberVO extends StringValidator implements Serializable {

    private static final int MAX_LENGTH = 9;
    private static final String REGEX = "[\\d]++";
    private String phoneNumber;

    public PhoneNumberVO(String phoneNumber){
        setValidatorData(phoneNumber);
        if (!isValid()) {
            throw new StringValidationException(String.format("%s must contains only digits, and be %d digits length.",
                    "Phone number", MAX_LENGTH));
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isValid() {
        return this.isValidLength() &&
               this.isFromCorrectCharacters();
    }

    private void setValidatorData(String phoneNumber) {
        this.setField(phoneNumber);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
