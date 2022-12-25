package objectCreator;

import lombok.*;
import objectCreatorClass.Annotation.Property;
import objectCreatorClass.Utils.ObjectCreatorClass;
import objectCreatorClass.model.Person;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatterBuilder;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectCreatorTest {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Student {
        @Property
        private String name = "john";
        @Property
        private int age = 45;
        @Property
        private Instant time = Instant.from((new DateTimeFormatterBuilder()
                .appendPattern("dd.MM.yyyy HH:mm")
                .toFormatter()
                .withZone(ZoneId.of("Europe/Kiev"))
                .parse("25.12.2022 07:45")));
    }

    @Test
    public void objectCreatorClass() {
        //GIVEN
        String PROPERTIES_PATH = "src/test/resources/props.properties";
        Path path = java.nio.file.Path.of(PROPERTIES_PATH);
        ObjectCreatorClass objectCreatorClass = new ObjectCreatorClass();
        Object expected = new Student();
        //WHEN
        Object actual = objectCreatorClass.loadFromProperties(Student.class, path);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void objectCreatorClassFields() {
        //GIVEN
        String PROPERTIES_PATH = "src/test/resources/props.properties";
        Path path = java.nio.file.Path.of(PROPERTIES_PATH);
        String expectedName = "john";
        int expectedAge = 45;
        Instant expectedTime = Instant.from((new DateTimeFormatterBuilder()
                .appendPattern("dd.MM.yyyy HH:mm")
                .toFormatter()
                .withZone(ZoneId.of("Europe/Kiev"))
                .parse("25.12.2022 07:45")));
        //WHEN
        Person actual = new ObjectCreatorClass().loadFromProperties(Person.class, path);
        //THEN
        assertEquals(expectedName, actual.getName());
        assertEquals(expectedAge, actual.getAge());
        assertEquals(expectedTime, actual.getTime());
    }
}
