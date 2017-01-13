package training.registration.handler.impl;

import org.springframework.stereotype.Component;
import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;
import training.registration.handler.RegistrationChainHandler;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Roman Horilyi
 */
@Component
public class TransactionalHandler implements RegistrationChainHandler {

    @Override
    public long handle(Car car, RegistrationChain chain) throws Exception {
        return chain.proceed(car);
    }
}
