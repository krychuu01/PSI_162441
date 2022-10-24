package pl.bookstore.basic;


import javax.persistence.*;

@MappedSuperclass
public class BasicEntity {

    public static final String SEQUENCE_NAME = "id_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_generator")
    @SequenceGenerator(name = "base_generator", sequenceName = SEQUENCE_NAME, allocationSize = 1)
    protected Long id;

}
