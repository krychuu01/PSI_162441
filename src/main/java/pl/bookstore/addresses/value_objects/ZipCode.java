package pl.bookstore.addresses.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class ZipCode extends StringValidator implements Serializable {

    private static final String REGEX = "[\\d-]++";
    private static final int MAX_LENGTH = 6;
    public String zipCode;

    public ZipCode(String zipCode){
        setValidatorData(zipCode);
        if(!isValid()) {
            throw new StringValidationException("ZipCode must be 6 signs length, contains only digits and dash sign.");
        }
        this.zipCode = zipCode;
    }

    @Override
    public boolean isValid() {
        return this.isFromCorrectCharacters() &&
               this.isExactLength();
    }

    private void setValidatorData(String zipCode){
        this.setField(zipCode);
        this.setRegex(REGEX);
        this.setExactLength(MAX_LENGTH);
    }

}
