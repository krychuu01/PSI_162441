package pl.bookstore.basic;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public interface DateValidator {

    default boolean isInFuture(LocalDate date){
        return date.isAfter(LocalDate.now());
    }

    default boolean isOldEnough(LocalDate date, int years){
        return date.isBefore(LocalDate.now().minusYears(years));
    }

}
