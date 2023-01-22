package pl.bookstore.graphql.bookDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookstore.graphql.authorDetails.AuthorGQL;
import pl.bookstore.graphql.authorDetails.AuthorGQLService;
import pl.bookstore.graphql.repository.AddressGQLRepository;
import pl.bookstore.graphql.repository.BookGQLRepository;
import pl.bookstore.graphql.userDetails.UserGQL;
import pl.bookstore.graphql.userDetails.UserGQLService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookGQLService {

    private final BookGQLRepository bookGQLRepository;
    private final AddressGQLRepository addressGQLRepository;
    private final AuthorGQLService authorGQLService;
    private final UserGQLService userGQLService;

    public List<BookGQL> findAllBooks() {
        return bookGQLRepository.findAll();
    }

    public BookGQL findBookById(Long id) {
        return bookGQLRepository.findById(id).orElse(null);
    }

    public List<BookGQL> findAllBooksByAuthorId(Long id) {
        return bookGQLRepository.findAllByAuthorId(id);
    }

    public List<BookGQL> findAllByTitle(String title) {
        return bookGQLRepository.findByTitleContains(title);
    }

    public BookGQL addBook(BookGQL bookGQL) {
        return bookGQLRepository.save(bookGQL);
    }

    public BookGQL changeBookName(Long id, String newTitle) {
        var book = findBookById(id);
        book.setTitle(newTitle);
        return bookGQLRepository.save(book);
    }

    public Long deleteBookById(Long id) {
        bookGQLRepository.deleteById(id);
        return id;
    }

//     służy do znalezienia książek których autorzy poochodzą z danego kraju
    public List<BookGQL> findBooksFromCountry(String country) {
        var authorsFromGivenCountry = userGQLService.findUsersByCountry(country);
        var authorsIds = authorsFromGivenCountry.stream()
                .mapToLong(UserGQL::getId)
                .boxed()
                .toList();
        return bookGQLRepository.findByAuthorIdsIn(authorsIds);
    }

    public List<BookGQL> findBooksWrittenBy(String authorsLastName) {
        var authors = authorGQLService.findAuthorsWithLastNameLike(authorsLastName);
        var authorsIds = authors
                .stream()
                .mapToLong(AuthorGQL::getId)
                .boxed()
                .toList();
        return bookGQLRepository.findByAuthorIdsIn(authorsIds);
    }

}
