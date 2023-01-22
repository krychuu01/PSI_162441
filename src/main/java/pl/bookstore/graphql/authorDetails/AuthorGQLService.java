package pl.bookstore.graphql.authorDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookstore.graphql.repository.AuthorGQLRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorGQLService {

    private final AuthorGQLRepository authorGQLRepository;


    public AuthorGQL addAuthor(AuthorGQL author) {
        return authorGQLRepository.save(author);
    }

    public List<AuthorGQL> findAllAuthors() {
        return authorGQLRepository.findAll();
    }

    public AuthorGQL findById(Long id) {
        return authorGQLRepository.findById(id).orElse(null);
    }

    public Long deleteById(Long id) {
        authorGQLRepository.deleteById(id);
        return id;
    }

    public List<AuthorGQL> findAllByFirstName(String firstName) {
        return authorGQLRepository.findByFirstNameLike(firstName);
    }

    public AuthorGQL changeAuthorsName(Long id, String firstName, String lastName) {
        var author = findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorGQLRepository.save(author);
        return author;
    }

    public List<AuthorGQL> findAuthorsWithLastNameLike(String lastName) {
        return authorGQLRepository.findByLastNameLike(lastName);
    }

}
