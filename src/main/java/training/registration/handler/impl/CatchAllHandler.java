package training.registration.handler.impl;

import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;
import training.registration.handler.RegistrationChainHandler;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Successfully stops processing of a chain.
 * @author Roman Horilyi
 */
@Data
@AllArgsConstructor
public class CatchAllHandler implements RegistrationChainHandler {

    private boolean fail;
    private String failMessage;

    @Override
    public long handle(Car car, RegistrationChain chain) throws Exception {
        if (fail) {
            throw new IllegalStateException(failMessage);
        }
        return car.getId();
    }
}
