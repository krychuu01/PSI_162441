package pl.bookstore.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select if(count(*) > 0, 'true', 'false') from books b where b.isbn = :isbn", nativeQuery = true)
    boolean existsByIsbn(@Param("isbn") String isbn);

}
