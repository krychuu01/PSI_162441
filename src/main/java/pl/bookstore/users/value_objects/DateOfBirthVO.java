package pl.bookstore.users.value_objects;


import lombok.NoArgsConstructor;
import pl.bookstore.basic.DateValidationException;
import pl.bookstore.basic.Validator;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
public class DateOfBirthVO extends Validator implements Serializable {

    LocalDate dateOfBirth;

    public DateOfBirthVO(LocalDate dateOfBirth) {
        if (!isValid(dateOfBirth)){
            throw new DateValidationException("Date cannot be null or be from the future.");
        }

        this.dateOfBirth = dateOfBirth;
    }

    public int getAge(LocalDate date) {
        return LocalDate.now().minusYears(date.getYear()).getYear();
    }


    @Override
    public boolean isValid(Object value) {
        return false;
    }

    @Override
    public void setValidatorData() {
        this.setDate(dateOfBirth);
    }

}
