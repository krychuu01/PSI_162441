package pl.bookstore.books.dtos;

import lombok.Builder;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.books.Book;
import pl.bookstore.books.value_objects.*;

public record BookDto(String isbn, String title, String numberOfPages, String yearOfPublication,
                      String publisher, Double price, String coverType) implements EntityDto<Book> {

    @Builder
    public BookDto {}

    @Override
    public Book toEntity() {
        return Book.builder()
                .isbn(new Isbn(this.isbn()))
                .title(new Title(this.title().trim()))
                .numberOfPages(new NumberOfPages(this.numberOfPages()))
                .yearOfPublication(new YearOfPublication(this.yearOfPublication()))
                .publisher(new Publisher(this.publisher()))
                .price(new Price(this.price()))
                .binding(Binding.getBindingType(this.coverType))
                .build();
    }

}
