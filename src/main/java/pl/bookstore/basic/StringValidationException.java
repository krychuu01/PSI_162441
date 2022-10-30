package pl.bookstore.basic;

public class StringValidationException extends RuntimeException {

    public StringValidationException(String fieldName, int minLength, int maxLength, String validChars) {
        super(getMessage(fieldName, minLength, maxLength, validChars));
    }

    public static String getMessage(String fieldName, int minLength, int maxLength, String validChars) {
        return String.format("%s must be between %d-%d characters length, and contains only %s",
                fieldName, minLength, maxLength, validChars);
    }

}
