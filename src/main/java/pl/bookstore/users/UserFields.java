package pl.bookstore.users;

public enum UserFields {

    ID("id"),
    LOGIN("login"),
    EMAIL("email"),
    PASSWORD("password"),
    FIRST_NAME("name.firstName"),
    LAST_NAME("name.lastName"),
    PHONE_NUMBER("phoneNumber");

    private final String fieldName;

    UserFields(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return this.fieldName;
    }

}
