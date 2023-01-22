package pl.bookstore.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bookstore.graphql.addressDetails.AddressGQL;

import java.util.List;

public interface AddressGQLRepository extends JpaRepository<AddressGQL, Long> {
    List<AddressGQL> findByCountry(String countryName);
}
