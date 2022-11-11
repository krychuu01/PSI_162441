package pl.bookstore.addresses.value_objects;


import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Country extends StringValidator {

    private static final String REGEX = "[a-zA-Z\\{Space}]++";
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 50;
    private String country;

    public Country(String country){
        setValidatorData(country);
        if (!isValid()) {
            throw new StringValidationException("Country must contains only letters and spaces.");
        }
    }

    @Override
    public boolean isValid(){
        return this.isLengthBetweenTwoValues() &&
               this.isFromCorrectCharacters();
    }

    private void setValidatorData(String country){
        this.setField(country);
        this.setRegex(REGEX);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
    }

}
