package training.registration.handler.impl;

import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;
import training.registration.handler.RegistrationChainHandler;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Roman Horilyi
 */
public class TransactionalHandler implements RegistrationChainHandler {

    @Override
    @Transactional
    public long handle(Car car, RegistrationChain chain) throws Exception {
        return chain.proceed(car);
    }
}
