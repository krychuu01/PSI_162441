package pl.bookstore.books_has_authors;

import lombok.Builder;

public record BooksHasAuthorDto(String title, String authorName) {

    @Builder
    public BooksHasAuthorDto {}

}
