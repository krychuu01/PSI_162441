package pl.bookstore.books_has_authors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookHasAuthorsRepository extends JpaRepository<BooksHasAuthor, Long> {



}
