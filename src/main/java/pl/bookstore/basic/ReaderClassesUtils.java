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

        var direction = sortDirection.isAscending() ? Sort.Direction.ASC : Sort.Direction.DESC;
        var pageable = PageRequest.of(number, size, Sort.by(direction, fieldName));

        return repository.findAll(pageable).getContent();
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
