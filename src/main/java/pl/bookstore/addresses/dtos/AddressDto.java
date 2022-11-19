package pl.bookstore.addresses.dtos;

import lombok.Builder;
import pl.bookstore.addresses.Address;
import pl.bookstore.addresses.value_objects.City;
import pl.bookstore.addresses.value_objects.Country;
import pl.bookstore.addresses.value_objects.Street;
import pl.bookstore.addresses.value_objects.ZipCode;
import pl.bookstore.basic.interfaces.EntityDto;

public record AddressDto(String zipCode, String street,
                         String city, String country) implements EntityDto<Address> {

    @Builder
    public AddressDto {};

    @Override
    public Address toEntity() {
        return Address.builder()
                .zipCode(new ZipCode(this.zipCode))
                .street(new Street(this.street))
                .city(new City(this.city))
                .country(new Country(this.country))
                .build();
    }

}
