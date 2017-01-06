package training.registration.service.impl;

import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;
import training.registration.exception.CarRegistrationException;
import training.registration.handler.RegistrationChainHandler;
import training.registration.service.CarRegistrationWebService;

import java.util.List;

/**
 * @author Roman Horilyi
 */
public class CarRegistrationWebServiceImpl implements CarRegistrationWebService {

    private List<RegistrationChainHandler> handlers;

    @Override
    public long registerCar(Car car) throws CarRegistrationException {
        try {
            return new RegistrationChain(handlers).proceed(car);
        } catch (CarRegistrationException e) {
            throw e;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
