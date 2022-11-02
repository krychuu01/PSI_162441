package pl.bookstore.basic.interfaces;

public interface StringValidatable extends Validatable{

    boolean isValidLength();

    boolean isFromCorrectCharacters();

}
