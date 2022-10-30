package pl.bookstore.users.value_objects;


import lombok.NoArgsConstructor;
import pl.bookstore.basic.DateValidationException;
import pl.bookstore.basic.DateValidator;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
public class DateOfBirthVO implements DateValidator {

    LocalDate dateOfBirth;

    public DateOfBirthVO(LocalDate dateOfBirth) {
        if (!isValid(dateOfBirth)){
            throw new DateValidationException("Date cannot be null or be from the future.");
        }
        if (!isOldEnough(dateOfBirth, getAge(dateOfBirth))) {
            throw new DateValidationException("You must be at least 16 years old to create an account.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge(LocalDate date) {
        return LocalDate.now().minusYears(date.getYear()).getYear();
    }

}
