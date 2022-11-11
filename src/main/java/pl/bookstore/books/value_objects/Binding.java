package pl.bookstore.books.value_objects;


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

}
