package pl.bookstore.books;

public enum BookFields {

    ID("id"),
    ISBN("isbn"),
    TITLE("title"),
    NUMBER_OF_PAGES("numberOfPages"),
    YEAR_OF_PUBLICATION("yearOfPublication"),
    PUBLISHER("publisher"),
    PRICE("price"),
    BINDING("binding");

    private final String fieldName;

    BookFields(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return this.fieldName;
    }
}
