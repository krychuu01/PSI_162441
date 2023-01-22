package pl.bookstore.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bookstore.graphql.authorDetails.AuthorGQL;

public interface AuthorGQLRepository extends JpaRepository<AuthorGQL, Long> {
}
