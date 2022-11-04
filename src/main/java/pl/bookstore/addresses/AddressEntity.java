package pl.bookstore.addresses;

import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.bookstore.addresses.value_objects.CityVO;
import pl.bookstore.addresses.value_objects.CountryVO;
import pl.bookstore.addresses.value_objects.StreetVO;
import pl.bookstore.addresses.value_objects.ZipCodeVO;
import pl.bookstore.basic.BasicEntity;
import pl.bookstore.users.UserEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class AddressEntity extends BasicEntity {

    @Embedded
    private ZipCodeVO zipCode;
    @Embedded
    private StreetVO street;
    @Embedded
    private CityVO city;
    @Embedded
    private CountryVO country;
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private UserEntity user;

    @Builder
    public AddressEntity(ZipCodeVO zipCode, StreetVO street, CityVO city, CountryVO country){
        this.zipCode = zipCode;
        this.street = street;
        this.city = city;
        this.country = country;
    }

}
