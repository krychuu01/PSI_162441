package pl.bookstore.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bookstore.graphql.bookDetails.BookGQL;

import java.util.List;

public interface BookGQLRepository extends JpaRepository<BookGQL, Long> {
    List<BookGQL> findByTitleContains(String title);
}
