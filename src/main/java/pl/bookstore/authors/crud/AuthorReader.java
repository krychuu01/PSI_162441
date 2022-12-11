package pl.bookstore.authors.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import pl.bookstore.authors.Author;
import pl.bookstore.authors.AuthorRepository;
import pl.bookstore.basic.interfaces.EntityDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorReader {

    private final static int PAGE_SIZE = 4;
    private final AuthorRepository authorRepository;
    public List<EntityDto<Author>> getAllAuthors(Integer page) {
        var pageNumber = getPageNumber(page);
        var authors = authorRepository.findAll(PageRequest.of(pageNumber, PAGE_SIZE)).getContent();
        return authors.stream()
                .map(Author::toDto)
                .collect(Collectors.toList());
    }

    public int getPageNumber(Integer page) {
        return page == null ? 0 : page;
    }

}
