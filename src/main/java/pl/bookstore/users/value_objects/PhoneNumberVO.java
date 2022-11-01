package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.StringValidationException;
import pl.bookstore.basic.StringValidator;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class PhoneNumberVO extends StringValidator implements Serializable {

    private static final int MAX_LENGTH = 9;
    private static final String REGEX = "[\\d]++";
    private String phoneNumber;

    public PhoneNumberVO(String phoneNumber){
        if (!isValid(phoneNumber)) {
            throw new StringValidationException(String.format("%s must contains only digits, and be %d digits length.",
                    "Phone number", MAX_LENGTH));
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isValid(Object value) {
        return this.isValidLength() && this.isFromCorrectCharacters();
    }

    @Override
    public void setValidatorData() {
        this.setField(phoneNumber);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
