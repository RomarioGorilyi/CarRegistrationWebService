package training.registration.handler;

import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;

/**
 * The handler abstraction
 * @author Roman Horilyi
 */
public interface RegistrationChainHandler {

    /**
     * Handles car registration.
     *
     * @param car the argument of the message type
     * @param chain a wrapper around handlers list, remembering the position (next handler to be executed)
     * @return the chain result value (some id)
     */
    long handle(Car car, RegistrationChain chain) throws Exception;
}
