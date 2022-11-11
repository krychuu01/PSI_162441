package pl.bookstore.books.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.interfaces.Validatable;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Publisher extends StringValidator implements Validatable {

    private static final String REGEX = "[\\p{Alnum}\\p{Punct}\\p{Space}]++";
    private static final int MAX_LENGTH = 45;
    private static final int MIN_LENGTH = 2;
    public String publisher;

    public Publisher(String publisher) {
        setValidatorData(publisher);
        if (!isValid()) {
            throw new StringValidationException(String.format(
                    "Publisher name should be between %d-%d digits length and consist only letters and digits.",
                    MIN_LENGTH, MAX_LENGTH)
            );
        }
        this.publisher = publisher;
    }

    @Override
    public boolean isValid() {
        return this.isFromCorrectCharacters() &&
               this.isLengthBetweenTwoValues();
    }

    private void setValidatorData(String publisher) {
        this.setField(publisher);
        this.setRegex(REGEX);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
    }

}
