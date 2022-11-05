package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class LoginVO extends StringValidator implements Serializable {

    private static final String REGEX = "TBA";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 20;
    public String login;

    public LoginVO(String login) {
        setValidatorData(login);
        if (!isValid()) {
            throw new StringValidationException(String.format("%s must be between %d-%d characters length, and contains only %s",
                    "Login", MIN_LENGTH, MAX_LENGTH, REGEX));
        }
        this.login = login;
    }

    @Override
    public boolean isValid(){
        return this.isValidLength() &&
               this.isFromCorrectCharacters();
    }

    private void setValidatorData(String login) {
        this.setField(login);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
