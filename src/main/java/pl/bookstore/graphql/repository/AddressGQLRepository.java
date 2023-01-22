package pl.bookstore.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bookstore.graphql.addressDetails.AddressGQL;

public interface AddressGQLRepository extends JpaRepository<AddressGQL, Long> {
}
