package pl.bookstore.addresses.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Street extends StringValidator {

    private static final String REGEX = "[\\p{Alnum}\\p{Space}\\p{Punct}]++";
    private static final int MAX_LENGTH = 50;
    private static final int MIN_LENGTH = 3;
    public String street;

    public Street(String street){
        setValidatorData(street);
        if (!isValid()) {
            throw new StringValidationException("Street must be between %d-%d signs length, and consist only alphanumerical sings.");
        }
        this.street = street;
    }

    @Override
    public boolean isValid(){
        return this.isLengthBetweenTwoValues() &&
               this.isFromCorrectCharacters();
    }

    private void setValidatorData(String street){
        this.setField(street);
        this.setRegex(REGEX);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
    }


}
