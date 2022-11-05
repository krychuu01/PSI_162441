package pl.bookstore.users;

import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.bookstore.addresses.AddressEntity;
import pl.bookstore.users.value_objects.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private LoginVO login;
    @Embedded
    private EmailVO email;
    @Embedded
    private PasswordVO password;
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
    })
    private NameVO name;
    @Embedded
    private PhoneNumberVO phoneNumber;
    @Embedded
    private DateOfBirthVO dateOfBirth;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "addresses_id")
    private AddressEntity address;

    @Builder
    public UserEntity(LoginVO login, EmailVO email, PasswordVO password, NameVO name, PhoneNumberVO phoneNumber, DateOfBirthVO dateOfBirth, AddressEntity address){
        this.login = login;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

}
