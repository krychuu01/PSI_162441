package pl.bookstore.orders.value_objects;

import javax.persistence.Embeddable;

@Embeddable
public class TotalPrice {

    public Double totalPrice;

    public TotalPrice() {
        this.totalPrice = 0.0;
    }

    public void add(Double amount) {
        this.totalPrice += amount;
    }

}
