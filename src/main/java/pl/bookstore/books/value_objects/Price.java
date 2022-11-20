package pl.bookstore.books.value_objects;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Price {

    public Double price;

    public Price(Double price) {
        if (!isValid(price)) {
            throw new IllegalStateException("Price can't be less than 0 or not given!");
        }
        this.price = price;
    }

    public boolean isValid(Double price) {
        return price != null && price > 0;
    }

}
