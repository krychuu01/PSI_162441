package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.Validator;
import pl.bookstore.basic.StringValidationException;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class NameVO extends Validator {

    public static final String REGEX = "[\\p{Alpha}\\p{Space}-']++";
    public static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 20;
    public String name;

    public NameVO(String name) {
        if (isValid(name)) {
            throw new StringValidationException("Name", MIN_LENGTH, MAX_LENGTH,
                    "alphanumeric signs, space and dash");
        }
        this.name = name;
    }


    @Override
    public boolean isValid(Object value) {
        return false;
    }

    @Override
    public void setValidatorData() {

    }

}
