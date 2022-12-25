package objectCreator;

import objectCreatorClass.Utils.ObjectCreatorClass;

import objectCreatorClass.model.Student;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

public class ObjectCreatorTest {

    @Test
    public void objectCreatorClassTest() {
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
}
