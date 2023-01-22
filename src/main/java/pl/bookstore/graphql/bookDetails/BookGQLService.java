package pl.bookstore.graphql.bookDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookstore.graphql.repository.BookGQLRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookGQLService {

    private final BookGQLRepository bookGQLRepository;

    public List<BookGQL> findAllBooks() {
        return bookGQLRepository.findAll();
    }

    public BookGQL findBookById(Long id) {
        return bookGQLRepository.findById(id).orElse(null);
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
}
