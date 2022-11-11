package pl.bookstore.books.value_objects;


import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.interfaces.Validatable;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class YearOfPublication extends StringValidator implements Validatable {

    private static final int LENGTH = 4;
    private static final String REGEX = "[\\d]++";
    public String yearOfPublication;

    public YearOfPublication(String yearOfPublication) {
        setValidatorData(yearOfPublication);
        if (!isValid()) {
            throw new StringValidationException("Year of publication should be 4 chars length and consist only digits.");
        }
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public boolean isValid() {
        return this.isFromCorrectCharacters() &&
               this.isExactLength();
    }

    public void setValidatorData(String yearOfPublication) {
        this.setField(yearOfPublication);
        this.setRegex(REGEX);
        this.setExactLength(LENGTH);
    }

}
