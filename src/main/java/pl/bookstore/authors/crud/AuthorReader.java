package pl.bookstore.authors.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import pl.bookstore.authors.Author;
import pl.bookstore.authors.AuthorRepository;
import pl.bookstore.basic.ReaderClassesUtils;
import pl.bookstore.basic.interfaces.EntityDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorReader {

    private final AuthorRepository authorRepository;

    public List<? extends EntityDto<Author>> getAllAuthors(Integer pageNumber, Integer pageSize) {
        var number = ReaderClassesUtils.validatePageNumber(pageNumber);
        var size = ReaderClassesUtils.validatePageNumber(pageSize);
        var authors = authorRepository.findAll(PageRequest.of(number, size)).getContent();

        return ReaderClassesUtils.getDtoList(authors);
    }

}
