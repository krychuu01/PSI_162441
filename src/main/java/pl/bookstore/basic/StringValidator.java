package pl.bookstore.basic;

import org.springframework.stereotype.Component;

import java.text.Normalizer;

@Component
public abstract class StringValidator implements Validatable{

    private String regex;
    private String field;
    private int minLength;
    private int maxLength;

    public boolean isValidLength() {
        return field.length() >= minLength && field.length() <= maxLength;
    }

    public boolean isFromCorrectCharacters() {
        var normalizedString = normalizeString(field);
        return normalizedString.matches(regex);
    }

    /**
     * Use this method to get rid of special characters from individual languages
     */

    private String normalizeString(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD);
    }


    /**
     * Setters below
     */

    protected StringValidator setField(String field) {
        this.field = field;
        return this;
    }

    protected StringValidator setRegex(String regex) {
        this.regex = regex;
        return this;
    }

    protected StringValidator setMinLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    protected StringValidator setMaxLength(int maxLength) {
        this.maxLength = maxLength;
        return this;
    }

}
