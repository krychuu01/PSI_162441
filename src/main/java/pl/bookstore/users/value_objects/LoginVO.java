package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.StringValidationException;
import pl.bookstore.basic.Validator;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class LoginVO extends Validator implements Serializable {

    private static final String REGEX = "";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 20;
    private String login;

    public LoginVO(String login) {
        if (!this.isValid(login)) {
            throw new StringValidationException("Login", MIN_LENGTH, MAX_LENGTH,
                    "upper and lower case letters, numbers and special signs");
        }
        this.login = login;
    }

    @Override
    public boolean isValid(Object value){
        setValidatorData();
        return this.isValidLength() && this.containsValidCharacters();
    }

    @Override
    public void setValidatorData() {
        this.setField(login);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
