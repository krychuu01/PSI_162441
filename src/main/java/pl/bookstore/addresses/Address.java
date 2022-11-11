package pl.bookstore.addresses;

import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.bookstore.addresses.value_objects.City;
import pl.bookstore.addresses.value_objects.Country;
import pl.bookstore.addresses.value_objects.Street;
import pl.bookstore.addresses.value_objects.ZipCode;
import pl.bookstore.users.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Table(name = "addresses")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private ZipCode zipCode;
    @Embedded
    private Street street;
    @Embedded
    private City city;
    @Embedded
    private Country country;
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "users_id")
    private User user;

    @Builder
    public Address(ZipCode zipCode, Street street, City city, Country country){
        this.zipCode = zipCode;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    /**
     *  Getters below
     */

    public Long getId() {
        return this.id;
    }

}
