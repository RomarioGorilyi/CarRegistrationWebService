package training.registration.handler.utils;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Roman Horilyi
 */
@Component
@Order(8)
public class CarRegisterRemote {

    public String register(String registrationNo, double engineCapacity) {
        // make some registration in a department
        return "NY dept";
    }
}
