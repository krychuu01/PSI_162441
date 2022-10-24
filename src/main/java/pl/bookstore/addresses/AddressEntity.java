package pl.bookstore.addresses;

import pl.bookstore.basic.BasicEntity;
import pl.bookstore.users.UserEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class AddressEntity extends BasicEntity {

    @OneToOne
    private UserEntity user;

}
