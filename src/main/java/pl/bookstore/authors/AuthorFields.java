package pl.bookstore.authors;

public enum AuthorFields {

    ID("id"),
    FIRST_NAME("name.firstName"),
    LAST_NAME("name.lastName");

    private final String fieldName;

    AuthorFields(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return this.fieldName;
    }
}
