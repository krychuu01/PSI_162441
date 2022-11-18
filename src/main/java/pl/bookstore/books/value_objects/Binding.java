package pl.bookstore.books.value_objects;


import java.util.Objects;
import java.util.stream.Stream;

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
        return Stream.of(values())
                .filter(binding -> binding.coverType.equals(coverType))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("coverType must be one of '%s', '%s' or '%s'",
                        E_BOOK.getCoverType(), SOFTCOVER.getCoverType(), HARDCOVER.getCoverType())));
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
