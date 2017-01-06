package training.registration.service;

import training.registration.domain.Car;
import training.registration.exception.CarRegistrationException;

import javax.jws.WebService;

/**
 * @author Roman Horilyi
 */
@WebService
public interface CarRegistrationWebService {
    long registerCar(Car car) throws CarRegistrationException;
}
