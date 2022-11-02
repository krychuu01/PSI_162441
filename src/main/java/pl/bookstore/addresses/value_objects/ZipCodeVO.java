package pl.bookstore.addresses.value_objects;

import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.validators.StringValidator;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class ZipCodeVO extends StringValidator implements Serializable {

    private static final String REGEX = "[\\d-]++";
    private static final int MAX_LENGTH = 6;
    private String zipCode;

    public ZipCodeVO(String zipCode){
        setValidatorData(zipCode);
        if(!isValid()) {
            throw new StringValidationException("ZipCode must be 6 signs length, contains only digits and dash sign.");
        }
        this.zipCode = zipCode;
    }

    @Override
    public boolean isValid() {
        return this.isFromCorrectCharacters() &&
               this.isValidLength();
    }

    @Override
    public boolean isValidLength(){
        return zipCode.length() == MAX_LENGTH;
    }

    private void setValidatorData(String zipCode){
        this.setField(zipCode);
        this.setRegex(REGEX);
    }

}
