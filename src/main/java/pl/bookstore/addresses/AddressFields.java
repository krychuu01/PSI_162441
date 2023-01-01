package pl.bookstore.addresses;

public enum AddressFields {

    ID("id"),
    ZIP_CODE("zipCode"),
    STREET("street"),
    CITY("city"),
    COUNTRY("country");

    private final String fieldName;

    AddressFields(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return this.fieldName;
    }
}
