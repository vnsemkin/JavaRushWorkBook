package objectCreatorClass.parser;

import objectCreatorClass.Annotation.Property;
import objectCreatorClass.exception.TypeNotSupportException;
import objectCreatorClass.exception.WrongFormatException;
import objectCreatorClass.reader.PropsReader;

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Properties;
import java.util.regex.Pattern;

public class Parser {
    private Property property;
    private String propsName;
    private final PropsReader propsReader = new PropsReader();
    private Properties properties;

    public Object parser(Field field, Path propertiesPath) {
        properties = propsReader.propsReader(propertiesPath);
        Class<?> fieldType = field.getType();
        property = field.getAnnotation(Property.class);
        if (fieldType.getSimpleName().equals("String") && field.getName().equals("name")) {
            return parseString(field);
        } else if (fieldType.getSimpleName().equals("int")
                || fieldType.getSimpleName().equals("Integer")
                && field.getName().equals("age")) {
            return parseInteger(field);
        } else if (fieldType.getSimpleName().equals("Instant") && field.getName().equals("time")) {
            return parseInstant(field);
        } else {
            try {
                throw new TypeNotSupportException();
            } catch (TypeNotSupportException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    private Instant parseInstant(Field field) {
        String timeFormat;
        propsName = properties.containsKey(field.getName()) ? field.getName() : property.timeProps();
        String timeProps = properties.getProperty(propsName);
        timeFormat = property.timeFormat();
        if (isTimeFormatCorrect(timeProps)) {
            return Instant.from((new DateTimeFormatterBuilder()
                    .appendPattern(timeFormat)
                    .toFormatter()
                    .withZone(ZoneId.of("Europe/Kiev"))
                    .parse(timeProps)));
        } else {
            try {
                throw new WrongFormatException();
            } catch (WrongFormatException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private Integer parseInteger(Field field) {
        propsName = properties.containsKey(field.getName()) ? field.getName() : property.numberProps();
        if (isInteger(properties.getProperty(propsName))) {
            return Integer.parseInt(properties.getProperty(propsName));
        } else {
            try {
                throw new TypeNotSupportException();
            } catch (TypeNotSupportException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    private String parseString(Field field) {
        propsName = properties.containsKey(field.getName()) ? field.getName() : property.valueProps();
        return properties.getProperty(propsName);
    }

    private boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (str == null) {
            return false;
        }
        return pattern.matcher(str).matches();
    }

    private boolean isTimeFormatCorrect(String str) {
        Pattern pattern = Pattern.compile("^\\d\\d.\\d\\d.\\d\\d\\d\\d\\s\\d\\d:\\d\\d");
        return pattern.matcher(str).matches();
    }
}
