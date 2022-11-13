package pl.bookstore.books.value_objects;


import pl.bookstore.basic.exceptions.StringValidationException;

import java.util.Objects;

public enum Binding {

    SOFTCOVER("softcover"),
    HARDCOVER("hardcover"),
    E_BOOK("e-book");

    private final String coverType;
    Binding(String coverType) {
        this.coverType = coverType;
    }

    public String getCoverType() {
        return this.coverType;
    }

    public static Binding getBindingType(String coverType) {
        if (Objects.equals(coverType, E_BOOK.getCoverType())){
            return E_BOOK;
        }
        if  (Objects.equals(coverType, SOFTCOVER.getCoverType())){
            return SOFTCOVER;
        }
        if (Objects.equals(coverType, HARDCOVER.getCoverType())) {
            return HARDCOVER;
        }
        throw new StringValidationException(
                String.format("coverType must be one of %s, %s or %s",
                        E_BOOK.getCoverType(), SOFTCOVER.getCoverType(), HARDCOVER.getCoverType())
        );
    }

    public boolean isSoftCover() {
        return Objects.equals(this.coverType, SOFTCOVER.getCoverType());
    }

    public boolean isHardCover() {
        return Objects.equals(this.coverType, HARDCOVER.getCoverType());
    }

    public boolean isEBook() {
        return Objects.equals(this.coverType, E_BOOK.getCoverType());
    }

}
