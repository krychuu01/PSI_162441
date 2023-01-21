package pl.bookstore.authors;

import lombok.Builder;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.users.value_objects.Name;

public record AuthorDto(Long id, String firstName, String lastName) implements EntityDto<Author> {

    @Builder
    public AuthorDto {}

    @Override
    public Author toEntity() {
        return Author.builder()
                .name(new Name(this.firstName(), this.lastName()))
                .build();
    }

}
