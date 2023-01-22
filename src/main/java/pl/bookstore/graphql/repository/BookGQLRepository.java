package pl.bookstore.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.bookstore.graphql.bookDetails.BookGQL;

import java.util.List;

public interface BookGQLRepository extends JpaRepository<BookGQL, Long> {
    List<BookGQL> findByTitleContains(String title);

    @Query("SELECT b FROM BookGQL b WHERE author =:authorId")
    List<BookGQL> findAllByAuthorId(@Param("authorId") Long id);

    @Query("SELECT b FROM BookGQL b WHERE author in :ids")
    List<BookGQL> findByAuthorIdsIn(@Param("ids") List<Long> authorsIds);

}
