package pl.bookstore.addresses;

import pl.bookstore.addresses.value_objects.CityVO;
import pl.bookstore.addresses.value_objects.CountryVO;
import pl.bookstore.addresses.value_objects.StreetVO;
import pl.bookstore.addresses.value_objects.ZipCodeVO;
import pl.bookstore.basic.BasicEntity;
import pl.bookstore.users.UserEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class AddressEntity extends BasicEntity {

    private ZipCodeVO zipCode;
    private StreetVO street;
    private CityVO city;
    private CountryVO country;
    @OneToOne
    private UserEntity user;

}
