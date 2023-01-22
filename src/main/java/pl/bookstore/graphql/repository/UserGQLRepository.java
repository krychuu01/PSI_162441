package pl.bookstore.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.bookstore.graphql.userDetails.UserGQL;

import java.util.List;

public interface UserGQLRepository extends JpaRepository<UserGQL, Long> {
    List<UserGQL> findByFirstNameLike(String firstName);

    @Query("SELECT u FROM UserGQL u WHERE address in :ids")
    List<UserGQL> findUsersByGivenAddressIds(@Param("ids") List<Long> addressesFromGivenCountry);
}
