package objectCreatorClass.model;

import lombok.*;
import objectCreatorClass.Annotation.Property;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Property
    private String name;
    @Property
    private int age;
    @Property
    private Instant time;
}
