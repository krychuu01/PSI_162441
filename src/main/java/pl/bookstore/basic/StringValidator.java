package pl.bookstore.basic;

import org.springframework.stereotype.Component;

@Component
public interface StringValidator {

    default boolean isValid(String field, int minLength, int maxLength, String regex) {
        return isNotNull(field) &&
               isValidLength(field, minLength, maxLength) &&
               containsValidCharacters(field, regex);
    }

    default boolean isNotNull(Object object) {
        return object != null;
    }

    default boolean isValidLength(String field, int moreThanOrEqual, int lessThanOrEqual) {
        return field.length() >= moreThanOrEqual && field.length() <= lessThanOrEqual;
    }

    default boolean containsValidCharacters(String field, String regex) {
        return field.matches(regex);
    }

}
