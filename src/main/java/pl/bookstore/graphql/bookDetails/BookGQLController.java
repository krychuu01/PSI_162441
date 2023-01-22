package pl.bookstore.graphql.bookDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookGQLController {

    private final BookGQLService service;

    @QueryMapping
    List<BookGQL> findAllBooks() {
        return service.findAllBooks();
    }

    @QueryMapping
    BookGQL findBookById(@Argument Long id) {
        return service.findBookById(id);
    }

    @QueryMapping
    List<BookGQL> findAllByTitle(@Argument String title) {
        return service.findAllByTitle(title);
    }

    @MutationMapping
    BookGQL addBook(@Argument BookGQL book) {
        return service.addBook(book);
    }

    @MutationMapping
    BookGQL changeBookName(@Argument Long id, @Argument String title) {
        return service.changeBookName(id, title);
    }

    @MutationMapping
    Long deleteBookById(@Argument Long id) {
        return service.deleteBookById(id);
    }

}
