package pl.bookstore.authors;

import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.bookstore.books.Book;
import pl.bookstore.users.value_objects.Name;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "authors")
public class Author {

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

}
