package pl.bookstore.basic;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.basic.interfaces.EntityMapper;

import java.util.List;

public class ReaderClassesUtils {

    public static <E extends EntityMapper<?>, R extends JpaRepository<E, Long>> List<E> getEntitiesSortedByField(
            R repository, Integer pageNumber, Integer pageSize, String fieldName, SortDirection sortDirection) {

        int number = validatePageNumber(pageNumber);
        int size = validatePageSize(pageSize);

        if (sortDirection.isAscending()) {
            return repository
                    .findAll(PageRequest
                            .of(number, size, Sort.by(Sort.Direction.ASC, fieldName)))
                    .getContent();
        }

        if (sortDirection.isDescending()) {
            return repository
                    .findAll(PageRequest
                            .of(number, size, Sort.by(Sort.Direction.DESC, fieldName)))
                    .getContent();
        }

        // if sort direction is not specified, result will not be sorted
        return repository.findAll(PageRequest.of(number, size)).getContent();
    }

    public static <DTO extends EntityDto<E>, E extends EntityMapper<DTO>> List<DTO> getDtoList(List<E> entityList) {
        return entityList.stream()
                .map(EntityMapper::toDto)
                .toList();
    }

    public static Integer validatePageNumber(Integer pageNumber) {
        return pageNumber == null ? 0 : pageNumber;
    }

    public static Integer validatePageSize(Integer pageSize) {
        if (pageSize == null) {
            return 5;
        }
        return pageSize < 5  ? 5 : pageSize;
    }

}
