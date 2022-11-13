package pl.bookstore.basic.interfaces;

import pl.bookstore.basic.ErrorListDto;

import java.util.List;

public interface CrudInterface<T>{

    ErrorListDto create(EntityDto<T> entityDto);

    EntityDto<T> readOne(Long entityId);

    List<EntityDto<T>> readAll();

    ErrorListDto updateField(Long entityId, EntityDto<T> entityDto, String fieldName);

    ErrorListDto delete(Long entityId);

}
