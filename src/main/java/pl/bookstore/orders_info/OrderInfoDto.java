package pl.bookstore.orders_info;

import lombok.Builder;

public record OrderInfoDto(String bookTitle, String coverType, String yearOfPublication, Double singleBookPrice, Integer booksAmount, Double price) {

    @Builder
    public OrderInfoDto {}

}
