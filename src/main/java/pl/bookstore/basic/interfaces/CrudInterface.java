package pl.bookstore.basic.interfaces;

import pl.bookstore.basic.MessageListDto;

import java.util.List;

public interface CrudInterface<T>{

    MessageListDto create(EntityDto<T> entityDto);

    EntityDto<T> readOne(Long id);

    List<EntityDto<T>> readAll();

    MessageListDto updateField(Long entityId, EntityDto<T> entityDto, String fieldName);

    MessageListDto delete(Long entityId);

}
