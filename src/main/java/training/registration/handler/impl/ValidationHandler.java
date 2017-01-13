package training.registration.handler.impl;

import org.springframework.stereotype.Component;
import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;
import training.registration.handler.RegistrationChainHandler;
import training.registration.handler.utils.Validate;

/**
 * @author Roman Horilyi
 */
@Component
public class ValidationHandler implements RegistrationChainHandler {

    @Override
    public long handle(Car car, RegistrationChain chain) throws Exception {
        Validate.notNull(car, "Car can't be null");
        Validate.notEmpty(car.getRegistrationNo(), "Registration number can't be empty");
        Validate.notNull(car.getColor(), "Color can't be null");
        Validate.notNull(car.getEngineCapacity(), "Engine capacity can't be null");
        Validate.notNull(car.getWeight(), "Weight can't be null");

        return chain.proceed(car);
    }
}
