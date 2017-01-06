package training.registration.handler.impl;

import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;
import training.registration.handler.RegistrationChainHandler;

import javax.annotation.Resource;

/**
 * @author Roman Horilyi
 */
public class RegisterInCarDeptHandler implements RegistrationChainHandler {

    @Resource
    private CarRegisterRemote carRegisterRemote;

    @Override
    public long handle(Car car, RegistrationChain chain) throws Exception {
        String carDeptId = carRegisterRemote.register(car.getRegistrationNo(), car.getEngineCapacity().doubleValue());
        car.setCarDeptId(carDeptId);

        return chain.proceed(car);
    }
}
