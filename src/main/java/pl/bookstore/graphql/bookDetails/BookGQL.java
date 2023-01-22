package pl.bookstore.graphql.bookDetails;

import javax.persistence.*;

@Entity
@Table(name = "book_gql")
public class BookGQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer numberOfPages;
    private Integer yearOfPublication;
    private Float price;
    @Column(name = "author_id")
    private Long author;

    public BookGQL() {

    }

    public BookGQL(String title, Integer numberOfPages, Integer yearOfPublication,
                   Float price, Long author) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
        this.author = author;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", yearOfPublication=" + yearOfPublication +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}
