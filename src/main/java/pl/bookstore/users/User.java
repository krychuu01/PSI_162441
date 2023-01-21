package pl.bookstore.users;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.bookstore.addresses.Address;
import pl.bookstore.basic.interfaces.EntityMapper;
import pl.bookstore.users.dtos.UserDto;
import pl.bookstore.users.value_objects.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User implements Serializable, EntityMapper<UserDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Login login;
    @Embedded
    private Email email;
    @Embedded
    private Password password;
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
    })
    private Name name;
    @Embedded
    private PhoneNumber phoneNumber;
    @Embedded
    private DateOfBirth dateOfBirth;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "addresses_id")
    private Address address;

    @Builder
    public User(Login login, Email email, Password password, Name name, PhoneNumber phoneNumber, DateOfBirth dateOfBirth, Address address){
        this.login = login;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    @Override
    public UserDto toDto() {
        return UserDto.builder()
                .id(this.id)
                .login(this.getLogin())
                .email(this.getEmail())
                .lastName(this.getLastName())
                .firstName(this.getFirstName())
                .dateOfBirth(this.getDateOfBirth())
                .password(this.getPassword())
                .phoneNumber(this.getPhoneNumber())
                .build();
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
    
    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
