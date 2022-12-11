package pl.bookstore.basic;

import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.basic.interfaces.EntityMapper;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public final class EntityUtils {

    public static String getFieldName(String fieldName, Class cls) {
        for (Field fieldname : cls.getDeclaredFields()) {
            if (fieldname.getName().equals(fieldName)) {
                return fieldname.getName();
            }
        }
        throw new IllegalStateException(String.format("Field name %s not found", fieldName));
    }

    public static <DTO extends EntityDto<E>, E extends EntityMapper<DTO>> List<DTO> getDtoList(List<E> entityList) {
        return entityList.stream()
                .map(EntityMapper::toDto)
                .collect(Collectors.toList());
    }

}
