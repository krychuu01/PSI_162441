package pl.bookstore.books.value_objects;


import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.interfaces.Validatable;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Isbn extends StringValidator implements Validatable {

    private static final String REGEX = "[\\d]++";
    private static final int FIRST_VALID_LENGTH = 10;
    private static final int SECOND_VALID_LENGTH = 13;
    public String isbn;

    public Isbn(String isbn) {
        setValidatorData(isbn);
        if (!isValid()) {
            throw new StringValidationException(
                    String.format("ISBN must be %d or %d length, and consist only digits",
                            FIRST_VALID_LENGTH, SECOND_VALID_LENGTH)
            );
        }
        this.isbn = isbn;
    }

    @Override
    public boolean isValid() {
        return this.isLengthBetweenTwoValues() &&
               this.isFromCorrectCharacters();
    }

    @Override
    public boolean isLengthBetweenTwoValues() {
        return isbn.length() == FIRST_VALID_LENGTH || isbn.length() == SECOND_VALID_LENGTH;
    }


    private void setValidatorData(String isbn) {
        this.setRegex(REGEX);
        this.setField(isbn);
    }

}
