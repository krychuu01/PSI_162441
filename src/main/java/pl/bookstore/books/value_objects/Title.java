package pl.bookstore.books.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.interfaces.Validatable;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Title extends StringValidator implements Validatable {

    private final static String REGEX = "[\\p{Alnum}\\p{Space}\\p{Punct}]++";
    private final static int MIN_LENGTH = 1;
    private final static int MAX_LENGTH = 50;
    public String title;

    public Title(String title) {
        setValidatorData(title);
        if(!isValid()) {
            throw new StringValidationException(
                    String.format("Title must be between %d-%d digits length, and consist only letters, digits, spaces and special marks.",
                            MIN_LENGTH, MAX_LENGTH)
            );
        }
        this.title = title;
    }

    @Override
    public boolean isValid() {
        return this.isLengthBetweenTwoValues() &&
               this.isFromCorrectCharacters();
    }

    private void setValidatorData(String title) {
        this.setField(title);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
