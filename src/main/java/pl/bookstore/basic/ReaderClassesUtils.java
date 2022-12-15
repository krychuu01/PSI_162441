package pl.bookstore.basic;

import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.basic.interfaces.EntityMapper;

import java.util.List;

public class ReaderClassesUtils {

    public static <DTO extends EntityDto<E>, E extends EntityMapper<DTO>> List<DTO> getDtoList(List<E> entityList) {
        return entityList.stream()
                .map(EntityMapper::toDto)
                .toList();
    }

    public static Integer validatePageNumber(Integer pageNumber) {
        return (pageNumber == null || pageNumber < 0) ? 0 : pageNumber;
    }

    public static Integer validatePageSize(Integer pageSize) {
        return (pageSize == null || pageSize < 0) ? 5 : pageSize;
    }

}
