package pl.bookstore.graphql;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bookstore.graphql.authorDetails.AuthorGQL;

@Controller
@RequestMapping("/api/graphql")
@RequiredArgsConstructor
public class AppController {

    private final QueryResolver queryResolver;
    private final MutationResolver mutationResolver;

    @PostMapping("/author")
    @MutationMapping("addAuthor")
    public AuthorGQL addAuthor(@Argument String firstName, @Argument String lastName) {
        return mutationResolver.addAuthor(firstName, lastName);
    }

}
