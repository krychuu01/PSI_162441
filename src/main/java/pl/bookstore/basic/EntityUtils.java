package pl.bookstore.basic;

import java.lang.reflect.Field;

public final class EntityUtils {

    public static String getFieldName(String fieldName, Class cls) {
        for (Field fieldname : cls.getDeclaredFields()) {
            if (fieldname.getName().equals(fieldName)) {
                return fieldname.getName();
            }
        }
        throw new IllegalStateException(String.format("Field name %s not found", fieldName));
    }

}
