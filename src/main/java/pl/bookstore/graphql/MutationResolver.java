package pl.bookstore.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.graphql.authorDetails.AuthorGQL;
import pl.bookstore.graphql.bookDetails.BookGQL;
import pl.bookstore.graphql.repository.AddressGQLRepository;
import pl.bookstore.graphql.repository.AuthorGQLRepository;
import pl.bookstore.graphql.repository.BookGQLRepository;
import pl.bookstore.graphql.repository.UserGQLRepository;

@Component
@RequiredArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {

    private final AddressGQLRepository addressGQLRepository;
    private final AuthorGQLRepository authorGQLRepository;
    private final BookGQLRepository bookGQLRepository;
    private final UserGQLRepository userGQLRepository;

    public AuthorGQL addAuthor(String firstName, String lastName) {
        var author = new AuthorGQL(firstName, lastName);
        var savedAuthor = authorGQLRepository.save(author);
        return savedAuthor;
    }

}
