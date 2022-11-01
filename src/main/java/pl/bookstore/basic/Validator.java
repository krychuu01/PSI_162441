package pl.bookstore.basic;

import org.springframework.stereotype.Component;

import java.text.Normalizer;
import java.time.LocalDate;

@Component
public abstract class Validator implements Validatable{

    protected String regex;
    protected String field;
    protected LocalDate date;
    protected int minLength;
    protected int maxLength;

    protected boolean isValidLength() {
        return field.length() >= minLength && field.length() <= maxLength;
    }

    protected boolean containsValidCharacters() {
        var normalizedString = normalizeString(field);
        return normalizedString.matches(regex);
    }

    /**
     *
     * Use this method to get rid of special characters from individual languages
     *
     */

    private String normalizeString(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD);
    }

    protected boolean isInFuture(LocalDate date){
        return date.isAfter(LocalDate.now());
    }

    protected boolean isOlderThan(int years){
        return date.minusYears(years).getYear() > 15;
    }

    /**
     * Setters below
     */

    public Validator setField(String field) {
        this.field = field;
        return this;
    }

    public Validator setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Validator setRegex(String regex) {
        this.regex = regex;
        return this;
    }

    public Validator setMinLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    public Validator setMaxLength(int maxLength) {
        this.maxLength = maxLength;
        return this;
    }

}
