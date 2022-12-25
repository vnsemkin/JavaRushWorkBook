package objectCreatorClass.Utils;

import objectCreatorClass.Annotation.Property;
import objectCreatorClass.parser.Parser;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;

public class ObjectCreatorClass {
    private final Parser parser = new Parser();

    public <T> T loadFromProperties(Class<T> clazz, Path propertiesPath) {
        T obj = null;
        Object o;
        try {
            obj = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        }
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Property.class)) {
                o = parser.parser(field, propertiesPath);
                if (o != null) {
                    try {
                        field.set(obj, o);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return obj;
    }
}