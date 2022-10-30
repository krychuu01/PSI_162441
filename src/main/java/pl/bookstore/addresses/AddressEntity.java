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

    private ZipCodeVO zipCode;
    private StreetVO street;
    private CityVO city;
    private CountryVO country;
    @OneToOne
    private UserEntity user;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinTable(name = "address_entity_user_entity",
            joinColumns = @JoinColumn(name = "address_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "user_entity_id"))
    private UserEntity users;

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }
}
