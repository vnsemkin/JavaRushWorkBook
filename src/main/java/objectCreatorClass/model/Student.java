package objectCreatorClass.model;

import lombok.*;
import objectCreatorClass.Annotation.Property;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatterBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
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

