package pl.bookstore.users.value_objects;


import lombok.NoArgsConstructor;
import pl.bookstore.basic.DateValidationException;
import pl.bookstore.basic.DateValidator;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
public class DateOfBirthVO extends DateValidator implements Serializable {

    private LocalDate dateOfBirth;

    public DateOfBirthVO(LocalDate dateOfBirth) {
        if (!isValid(dateOfBirth)){
            throw new DateValidationException("You must be at least 16 years old to create an account.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge(LocalDate date) {
        return LocalDate.now().minusYears(date.getYear()).getYear();
    }

    @Override
    public boolean isValid(Object value) {
        return this.isOlderThan(15);
    }

    @Override
    public void setValidatorData() {
        this.setDate(dateOfBirth);
    }

}
