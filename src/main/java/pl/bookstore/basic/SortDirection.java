package pl.bookstore.basic;

import java.util.Objects;

public enum SortDirection {

    ASC("asc"),
    DESC("desc"),
    NONE("none"); // this should be used when no sorting is needed

    private final String sortType;

    SortDirection(String sortType) {
        this.sortType = sortType;
    }

    public String getSortType() {
        return this.sortType;
    }

    public boolean isAscending() {
        return Objects.equals(this.sortType, ASC.getSortType());
    }

    public boolean isDescending() {
        return Objects.equals(this.sortType, DESC.getSortType());
    }

    public boolean isNone() {
        return Objects.equals(this.sortType, NONE.getSortType());
    }

}
