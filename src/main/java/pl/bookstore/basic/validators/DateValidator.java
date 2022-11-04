package pl.bookstore.basic.validators;

import pl.bookstore.basic.interfaces.DateValidatable;

import java.time.LocalDate;

public abstract class DateValidator implements DateValidatable {

    private LocalDate date;

    @Override
    public boolean isInFuture(){
        return date.isAfter(LocalDate.now());
    }

    public boolean isOlderThan(int years){
        var currentYear = getCurrentYear();
        return currentYear - date.getYear() > years;
    }

    public int getCurrentYear() {
        return LocalDate.now().getYear();
    }

    /**
     * Setters below
     */

    protected DateValidator setDate(LocalDate date) {
        this.date = date;
        return this;
    }

}
