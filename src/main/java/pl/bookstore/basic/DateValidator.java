package pl.bookstore.basic;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public interface DateValidator {

    default boolean isValid(LocalDate date) {
        return isNotNull(date) && isInFuture(date);
    }

    default boolean isNotNull(LocalDate date) {
        return date != null;
    }

    default boolean isInFuture(LocalDate date){
        return date.isAfter(LocalDate.now());
    }

    default boolean isOldEnough(LocalDate date, int years){
        return date.minusYears(years).getYear() > 15;
    }

}
