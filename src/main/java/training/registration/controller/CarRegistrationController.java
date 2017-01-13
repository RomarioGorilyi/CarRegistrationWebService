package training.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training.registration.domain.Car;
import training.registration.exception.CarRegistrationException;
import training.registration.service.CarRegistrationService;

/**
 * @author Roman Horilyi
 */
@RestController
public class CarRegistrationController {

    private final CarRegistrationService carRegistrationWebService;

    @Autowired
    public CarRegistrationController(CarRegistrationService carRegistrationWebService) {
        this.carRegistrationWebService = carRegistrationWebService;
    }

    @RequestMapping(value = "/registration/newCar", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void makeCarRegistration(@RequestBody Car car) throws CarRegistrationException {
        carRegistrationWebService.registerCar(car);
    }
}
