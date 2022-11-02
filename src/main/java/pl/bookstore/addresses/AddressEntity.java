package pl.bookstore.addresses;

import pl.bookstore.addresses.value_objects.CityVO;
import pl.bookstore.addresses.value_objects.CountryVO;
import pl.bookstore.addresses.value_objects.StreetVO;
import pl.bookstore.addresses.value_objects.ZipCodeVO;
import pl.bookstore.basic.BasicEntity;
import pl.bookstore.users.UserEntity;

import javax.persistence.*;

@Entity
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

}
