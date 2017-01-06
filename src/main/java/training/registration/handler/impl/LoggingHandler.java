package training.registration.handler.impl;

import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;
import training.registration.handler.RegistrationChainHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Roman Horilyi
 */
public class LoggingHandler implements RegistrationChainHandler {

    private static final Logger log = LoggerFactory.getLogger(LoggingHandler.class);

    @Override
    public long handle(Car car, RegistrationChain chain) throws Exception {
        log.debug("Processing car: {}", car);
        return chain.proceed(car);
    }
}
