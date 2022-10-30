package pl.bookstore.users.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.StringValidator;
import pl.bookstore.basic.ValidationException;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class NameVO implements StringValidator {

    public static final String REGEX = "^[A-Za-z]+([A-Za-z0-9]*|[._-]?[A-Za-z0-9]+)*$";
    public static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 20;
    public String name;

    public NameVO(String name) {
        if (isValid(name, MIN_LENGTH, MAX_LENGTH, REGEX)) {
            throw new ValidationException("Name", MIN_LENGTH, MAX_LENGTH, REGEX);
        }
        this.name = name;
    }

}
