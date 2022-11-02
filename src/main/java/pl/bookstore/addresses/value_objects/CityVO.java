package pl.bookstore.addresses.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class CityVO extends StringValidator {

    private static final String REGEX = "TBA";
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 30;
    private String city;

    public CityVO(String city){
        setValidatorData(city);
        if (!isValid()) {
            throw new StringValidationException(String.format("City must be between %d-%d and contains only alphanumerical signs",
                    MIN_LENGTH, MAX_LENGTH));
        }
        this.city = city;
    }


    @Override
    public boolean isValid() {
        return this.isValidLength() &&
               this.isFromCorrectCharacters();
    }

    private void setValidatorData(String city){
        this.setField(city);
        this.setRegex(REGEX);
        this.setMinLength(MIN_LENGTH);
        this.setMaxLength(MAX_LENGTH);
    }

}
