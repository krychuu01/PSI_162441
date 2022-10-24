package pl.bookstore.users.value_objects;


import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
public class DateOfBirthVO {

    LocalDate date;

}
