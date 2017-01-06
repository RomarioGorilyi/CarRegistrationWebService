package training.registration.handler.impl;

import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;
import training.registration.exception.CarRegistrationException;
import training.registration.handler.RegistrationChainHandler;

/**
 * Hides the details of your system and provide less verbose messages to the client.
 * @author Roman Horilyi
 */
public class ExceptionTranslatorHandler implements RegistrationChainHandler {

    @Override
    public long handle(Car car, RegistrationChain chain) throws Exception {
        try {
            return chain.proceed(car);
        } catch (CarRegistrationException e) {
            throw e;
        } catch (Exception e) {
            throw new CarRegistrationException("Error while registering car", e);
        }
    }
}