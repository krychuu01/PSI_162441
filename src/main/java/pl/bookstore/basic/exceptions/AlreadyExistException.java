package pl.bookstore.basic.exceptions;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String className) {
        super(className + " already exists!");
    }

}
