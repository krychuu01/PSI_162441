package pl.bookstore.users.value_objects;


import lombok.NoArgsConstructor;
import pl.bookstore.basic.exceptions.DateValidationException;
import pl.bookstore.basic.validators.DateValidator;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
public class DateOfBirthVO extends DateValidator implements Serializable {

    private LocalDate dateOfBirth;

    public DateOfBirthVO(LocalDate dateOfBirth) {
        setValidatorData(dateOfBirth);
        if (!isValid()){
            throw new DateValidationException("You must be at least 16 years old to create an account.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return this.getCurrentYear() - dateOfBirth.getYear();
    }

    @Override
    public boolean isValid() {
        return this.isInFuture() &&
               this.isOlderThan(15);
    }

    private void setValidatorData(LocalDate date) {
        this.setDate(date);
    }

}
