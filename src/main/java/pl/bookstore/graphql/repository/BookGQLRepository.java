package pl.bookstore.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bookstore.graphql.bookDetails.BookGQL;

public interface BookGQLRepository extends JpaRepository<BookGQL, Long> {
}
