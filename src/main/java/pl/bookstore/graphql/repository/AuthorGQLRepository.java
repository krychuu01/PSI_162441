package pl.bookstore.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bookstore.graphql.authorDetails.AuthorGQL;

import java.util.List;

public interface AuthorGQLRepository extends JpaRepository<AuthorGQL, Long> {
    List<AuthorGQL> findByFirstNameLike(String firstName);

}
