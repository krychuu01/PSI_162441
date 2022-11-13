package pl.bookstore.books.value_objects;


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
