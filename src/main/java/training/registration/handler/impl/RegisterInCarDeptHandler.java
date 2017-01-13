package training.registration.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;
import training.registration.handler.RegistrationChainHandler;

/**
 * @author Roman Horilyi
 */
@Component
public class RegisterInCarDeptHandler implements RegistrationChainHandler {

    private final CarRegisterRemote carRegisterRemote;

    public RegisterInCarDeptHandler(CarRegisterRemote carRegisterRemote) {
        this.carRegisterRemote = carRegisterRemote;
    }

    @Override
    public long handle(Car car, RegistrationChain chain) throws Exception {
        String carDeptId = carRegisterRemote.register(car.getRegistrationNo(), car.getEngineCapacity().doubleValue());
        car.setCarDeptId(carDeptId);

        return chain.proceed(car);
    }
}
