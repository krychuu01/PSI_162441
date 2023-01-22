package pl.bookstore.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.graphql.authorDetails.AuthorGQL;
import pl.bookstore.graphql.repository.AddressGQLRepository;
import pl.bookstore.graphql.repository.AuthorGQLRepository;
import pl.bookstore.graphql.repository.BookGQLRepository;
import pl.bookstore.graphql.repository.UserGQLRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {

    private final AddressGQLRepository addressGQLRepository;
    private final AuthorGQLRepository authorGQLRepository;
    private final BookGQLRepository bookGQLRepository;
    private final UserGQLRepository userGQLRepository;

    public List<AuthorGQL> findAllAuthors() {
        return authorGQLRepository.findAll();
    }

}
