package pl.bookstore.authors.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.authors.Author;
import pl.bookstore.authors.AuthorRepository;
import pl.bookstore.basic.ReaderClassesUtils;
import pl.bookstore.basic.SortDirection;
import pl.bookstore.basic.interfaces.EntityDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorReader {

    private final AuthorRepository repository;

    public List<? extends EntityDto<Author>> getAllAuthors(Integer pageNumber, Integer pageSize, String fieldName, SortDirection sortDirection) {
        var authors = ReaderClassesUtils.getEntitiesSortedByField(repository, pageNumber, pageSize, fieldName, sortDirection);
        return ReaderClassesUtils.getDtoList(authors);
    }

}
