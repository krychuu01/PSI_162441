package pl.bookstore.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bookstore.graphql.userDetails.UserGQL;

public interface UserGQLRepository extends JpaRepository<UserGQL, Long> {
}
