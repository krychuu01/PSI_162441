package pl.bookstore.basic;

import java.time.LocalDate;

public abstract class DateValidator implements Validatable{

    private LocalDate date;

    public boolean isInFuture(LocalDate date){
        return date.isAfter(LocalDate.now());
    }

    public boolean isOlderThan(int years){
        return date.minusYears(years).getYear() > 15;
    }

    /**
     * Setters below
     */

    protected DateValidator setDate(LocalDate date) {
        this.date = date;
        return this;
    }

}
