package pl.bookstore.graphql.bookDetails;

import pl.bookstore.graphql.authorDetails.AuthorGQL;

import javax.persistence.*;

@Entity
@Table(name = "book_gql")
public class BookGQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String isbn;
    private Integer numberOfPages;
    private Integer yearOfPublication;
    private String publisher;
    private Float price;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorGQL authorGQL;

    public BookGQL() {

    }

    public BookGQL(String title, String isbn, Integer numberOfPages, Integer yearOfPublication,
                   String publisher, Float price, AuthorGQL author) {
        this.title = title;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
        this.price = price;
        this.authorGQL = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public AuthorGQL getAuthor() {
        return authorGQL;
    }

    public void setAuthor(AuthorGQL author) {
        this.authorGQL = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", yearOfPublication=" + yearOfPublication +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", author=" + authorGQL +
                '}';
    }
}
