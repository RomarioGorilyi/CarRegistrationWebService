package training.registration.service;

import training.registration.domain.Car;
import training.registration.exception.CarRegistrationException;

/**
 * @author Roman Horilyi
 */
public interface CarRegistrationService {
    long registerCar(Car car) throws CarRegistrationException;
}
