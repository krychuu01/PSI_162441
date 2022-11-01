package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.StringValidationException;
import pl.bookstore.basic.StringValidator;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class LoginVO extends StringValidator implements Serializable {

    private static final String REGEX = "TBA";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 20;
    private String login;

    public LoginVO(String login) {
        if (!isValid(login)) {
            throw new StringValidationException(String.format("%s must be between %d-%d characters length, and contains only %s",
                    "Login", MIN_LENGTH, MAX_LENGTH, REGEX));
        }
        this.login = login;
    }

    @Override
    public boolean isValid(Object value){
        setValidatorData();
        return this.isValidLength() && this.isFromCorrectCharacters();
    }

    @Override
    public void setValidatorData() {
        this.setField(login);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
