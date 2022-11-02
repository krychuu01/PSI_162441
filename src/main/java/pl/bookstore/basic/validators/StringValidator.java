package pl.bookstore.basic.validators;

import org.springframework.stereotype.Component;
import pl.bookstore.basic.interfaces.StringValidatable;

import java.text.Normalizer;

@Component
public abstract class StringValidator implements StringValidatable {

    private String regex;
    private String field;
    private int minLength;
    private int maxLength;

    @Override
    public boolean isValidLength() {
        return field.length() >= minLength && field.length() <= maxLength;
    }

    @Override
    public boolean isFromCorrectCharacters() {
        var normalizedField = normalizeField(field);
        return normalizedField.matches(regex);
    }

    /**
     * Use this method to get rid of special characters from individual languages
     */

    private String normalizeField(String str) {
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
