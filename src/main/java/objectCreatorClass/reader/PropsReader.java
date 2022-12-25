package objectCreatorClass.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class PropsReader {
    public Properties propsReader(Path pathToProperties) {
        final Properties props = new Properties();
        try (FileInputStream file = new FileInputStream(pathToProperties.toFile())) {
            props.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}
