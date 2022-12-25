package objectCreatorClass.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Property {
    String valueProps() default "stringProperty";

    String numberProps() default "numberProperty";

    String timeProps() default "timeProperty";

    String timeFormat() default "dd.MM.yyyy HH:mm";
}

