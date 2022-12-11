package pl.bookstore.books_has_authors;

import lombok.Builder;
import pl.bookstore.basic.interfaces.EntityDto;

public record BooksHasAuthorDto(String title, String authorName) {

    @Builder
    public BooksHasAuthorDto {}

}
