package pl.bookstore.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select if(count(*) > 0, 'true', 'false') from users u where u.email = :email", nativeQuery = true)
    boolean existsByEmail(@Param("email") String email);

    @Query(value = "select if(count(*) > 0, 'true', 'false') from users u where u.login = :login", nativeQuery = true)
    boolean existsByLogin(@Param("login") String login);

}
