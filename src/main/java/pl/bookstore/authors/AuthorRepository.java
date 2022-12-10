package pl.bookstore.authors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = """
                      select if(count(*) > 0, 'true', 'false')
                      from authors a where a.first_name = :firstName
                      and a.last_name = :lastName
                   """, nativeQuery = true)
    boolean existsByName(@Param("firstName")String firstName, @Param("lastName") String lastName);

}
