package pl.bookstore.authors;

import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.bookstore.addresses.value_objects.City;
import pl.bookstore.addresses.value_objects.Country;
import pl.bookstore.addresses.value_objects.Street;
import pl.bookstore.addresses.value_objects.ZipCode;
import pl.bookstore.basic.interfaces.EntityMapper;
import pl.bookstore.users.value_objects.Name;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Table(name = "authors")
public class Author implements Serializable, EntityMapper<AuthorDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
    })
    private Name name;

    @Builder
    public Author(Name name) {
        this.name = name;
    }

    @Override
    public AuthorDto toDto() {
        return AuthorDto.builder()
                .firstName(this.name.firstName)
                .lastName(this.name.lastName)
                .build();
    }

    public String getFirstName() {
        return this.name.firstName;
    }

    public String getLastName() {
        return this.name.lastName;
    }

    public void setName(Name newName) {
        this.name = newName;
    }

}
