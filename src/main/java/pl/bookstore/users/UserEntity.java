package pl.bookstore.users;

import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.bookstore.addresses.AddressEntity;
import pl.bookstore.basic.BasicEntity;
import pl.bookstore.users.value_objects.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "users")
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
    @OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE, mappedBy = "users")
    private AddressEntity address;

    @Builder
    public UserEntity(LoginVO login, EmailVO email, PasswordVO password, NameVO firstName, NameVO lastName, PhoneNumberVO phoneNumber, DateOfBirthVO dateOfBirth, AddressEntity address){
        this.login = login;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }


}
