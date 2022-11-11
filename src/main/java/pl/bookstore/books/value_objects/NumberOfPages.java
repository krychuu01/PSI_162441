package pl.bookstore.books.value_objects;


import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.interfaces.Validatable;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class NumberOfPages extends StringValidator implements Validatable {

    private final static String REGEX = "[\\d]++";
    private final static int MIN_LENGTH = 1;
    private final static int MAX_LENGTH = 4;
    public String numberOfPages;

    public NumberOfPages(String numberOfPages) {
        setValidatorData(numberOfPages);
        if(!isValid()){
            throw new StringValidationException(
                    String.format("Number of digits should be from %s to %s chars length and consist only digits.",
                    MIN_LENGTH, MAX_LENGTH)
            );
        }
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean isValid() {
        return this.isLengthBetweenTwoValues() &&
               this.isFromCorrectCharacters();
    }

    private void setValidatorData(String numberOfPages){
        this.setField(numberOfPages);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
        this.setRegex(REGEX);
    }

}
