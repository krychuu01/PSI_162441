package pl.bookstore.books_has_authors;


import lombok.NoArgsConstructor;
import pl.bookstore.basic.interfaces.EntityMapper;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "books_has_authors")
@NoArgsConstructor
public class BooksHasAuthor implements Serializable, EntityMapper<BooksHasAuthorDto> {


    @Override
    public BooksHasAuthorDto toDto() {
        return null;
    }

}
