package pl.bookstore.basic.interfaces;

import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.dto.UpdateDto;

import java.util.List;

public interface CrudInterface<T>{

    MessageListDto create(EntityDto<T> entityDto);

    EntityDto<T> readOne(Long id);

    List<EntityDto<T>> readAll(Integer page);

    MessageListDto updateField(Long entityId, UpdateDto dto);

    MessageListDto delete(Long entityId);

}
