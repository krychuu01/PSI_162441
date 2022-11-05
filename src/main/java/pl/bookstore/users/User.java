package pl.bookstore.users;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.bookstore.addresses.AddressEntity;
import pl.bookstore.users.value_objects.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User implements Serializable {

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
    public User(LoginVO login, EmailVO email, PasswordVO password, NameVO name, PhoneNumberVO phoneNumber, DateOfBirthVO dateOfBirth, AddressEntity address){
        this.login = login;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    /**
     * Getters below
     */

    public String getLogin() {
        return this.login.login;
    }

    public String getEmail() {
        return this.email.email;
    }

    public String getPassword() {
        return this.password.password;
    }

    public String getFirstName() {
        return this.name.firstName;
    }

    public String getLastName() {
        return this.name.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber.phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth.dateOfBirth;
    }

    //
    public AddressEntity getAddress() {
        throw new IllegalStateException("To be implemented!");
    }

}
