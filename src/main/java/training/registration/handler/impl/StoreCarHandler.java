package training.registration.handler.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;
import training.registration.handler.RegistrationChainHandler;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Roman Horilyi
 */
@Component
@Order(7)
public class StoreCarHandler implements RegistrationChainHandler {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public long handle(Car car, RegistrationChain chain) throws Exception {
        entityManager.persist(car);
        return chain.proceed(car);
    }
}
