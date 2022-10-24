package pl.bookstore.users;

import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.bookstore.addresses.AddressEntity;
import pl.bookstore.basic.BasicEntity;
import pl.bookstore.users.value_objects.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
public class UserEntity extends BasicEntity {

    @Embedded
    private LoginVO login;
    @Embedded
    private EmailVO email;
    @Embedded
    private PasswordVO password;
    @Embedded
    private NameVO firstName;
    @Embedded
    private NameVO lastName;
    @Embedded
    private PhoneNumberVO phoneNumber;
    @Embedded
    private DateOfBirthVO dateOfBirth;
    @OneToOne
    private AddressEntity address;

    @Builder
    public UserEntity(LoginVO login, EmailVO email, PasswordVO password, NameVO firstName, NameVO lastName, PhoneNumberVO phoneNumber, DateOfBirthVO dateOfBirth, AddressEntity address){
        this.login = login;
        this.email = email;
        this.password = password;
    }

}
