package pl.bookstore.graphql.authorDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorGQLController {
    private final AuthorGQLService authorGQLService;

    @QueryMapping
    public AuthorGQL findAuthorById(@Argument Long id) {
        return authorGQLService.findById(id);
    }

    @QueryMapping
    public List<AuthorGQL> findAllAuthors() {
        return authorGQLService.findAllAuthors();
    }

    @QueryMapping
    public List<AuthorGQL> findAuthorsByFirstName(@Argument String firstName) {
        return authorGQLService.findAllByFirstName(firstName);
    }

    @MutationMapping
    public AuthorGQL addAuthor(@Argument AuthorGQL author) {
        return authorGQLService.addAuthor(author);
    }

    @MutationMapping
    public AuthorGQL changeAuthorsName(@Argument Long id, @Argument String firstName, @Argument String lastName) {
        return authorGQLService.changeAuthorsName(id, firstName, lastName);
    }

    @MutationMapping
    public Long deleteAuthorById(@Argument Long id) {
        return authorGQLService.deleteById(id);
    }

}
