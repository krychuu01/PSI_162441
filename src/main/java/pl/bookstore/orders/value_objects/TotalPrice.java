package pl.bookstore.orders.value_objects;

import javax.persistence.Embeddable;

@Embeddable
public class TotalPrice {

    public Double totalPrice;

    public TotalPrice() {
        this.totalPrice = 0.0;
    }

    public TotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public TotalPrice getTotalPriceWithDiscount(Integer discount) {
        if (discount < 0 || discount > 50) throw new IllegalStateException("Discount can't be less than 0 or greater than 50%!");
        var discountPercentage = discount.doubleValue() / 100;
        return new TotalPrice(this.totalPrice - (this.totalPrice * discountPercentage));
    }

    public void add(Double amount) {
        this.totalPrice += amount;
    }

}
