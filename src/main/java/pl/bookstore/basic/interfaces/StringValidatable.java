package pl.bookstore.basic.interfaces;

public interface StringValidatable extends Validatable{

    boolean isLengthBetweenTwoValues();

    boolean isExactLength();

    boolean isFromCorrectCharacters();

}
