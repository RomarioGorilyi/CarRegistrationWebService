package training.registration.handler.impl;

import org.springframework.stereotype.Component;
import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;
import training.registration.exception.CarRegistrationException;
import training.registration.handler.RegistrationChainHandler;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * This handler instead of running proceed() method immediately,
 * creates a Callable<Long> instance wrapping it (Adapter pattern!) and submitting to the thread pool.
 * Then, using Future<Long> we wait configured time for the result.
 * If the task reaches the available thread in pool and is fully executed (it means, all handlers below are run),
 * everything works transparently for the client.
 * But if the invocation has not finished and the timeout is reached, client will get only error message.
 * @author Roman Horilyi
 */
//@Component
public class HandlerWithTimeout implements RegistrationChainHandler {

    @Resource
    private ExecutorService executorService;
    private long timeoutInMillis = 5000;

    @Override
    public long handle(Car car, RegistrationChain chain) throws Exception {
        Future<Long> registrationResult = executorService.submit(() -> chain.proceed(car));

        try {
            return registrationResult.get(timeoutInMillis, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof Exception) {
                throw ((Exception) e.getCause());
            }
            else {
                throw new CarRegistrationException(e.getCause());
            }
        } catch (TimeoutException e) {
            registrationResult.cancel(true);
            throw new CarRegistrationException("Registration did not finished after " + timeoutInMillis + "ms");
        }
    }
}
