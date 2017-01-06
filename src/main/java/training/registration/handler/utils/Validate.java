package training.registration.handler.utils;

import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author Roman Horilyi
 */
public class Validate {

    public static void notNull(Object object, String message) {
        if (Objects.isNull(object)) {
            System.out.println(message);
        }
    }

    public static void notEmpty(Object object, String message) {
        if (StringUtils.isEmpty(object)) {
            System.out.println(message);
        }
    }
}
