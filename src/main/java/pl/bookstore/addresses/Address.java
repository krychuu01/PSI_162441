package pl.bookstore.addresses;

import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.bookstore.addresses.dtos.AddressDto;
import pl.bookstore.addresses.value_objects.City;
import pl.bookstore.addresses.value_objects.Country;
import pl.bookstore.addresses.value_objects.Street;
import pl.bookstore.addresses.value_objects.ZipCode;
import pl.bookstore.basic.interfaces.EntityMapper;
import pl.bookstore.books.value_objects.*;
import pl.bookstore.users.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Table(name = "addresses")
public class Address implements Serializable, EntityMapper<AddressDto> {

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

    @Override
    public AddressDto toDto() {
        return AddressDto.builder()
                .street(this.street != null ? getStreet() : "Street name unfilled.")
                .city(this.city != null ? getCity() : "City name unfilled.")
                .zipCode(this.zipCode != null ? getZipCode() : "Zip code unfilled.")
                .country(this.country != null ? getCountry() : "Country unfilled.")
                .build();
    }

    public void setFieldValue(String fieldName, String value) {
        switch (fieldName) {
            case "street" -> this.street = new Street(value);
            case "city" -> this.city = new City(value);
            case "zipCode" -> this.zipCode = new ZipCode(value);
            case "country" -> this.country = new Country(value);
            default -> throw new IllegalStateException("Field not found or can't be changed.");
        }
    }

    /**
     *  Getters below
     */

    public Long getId() {
        return this.id;
    }

    public String getStreet() {
        return street.street;
    }

    public String getZipCode() {
        return zipCode.zipCode;
    }

    public String getCity() {
        return city.city;
    }

    public String getCountry() {
        return country.country;
    }
}
