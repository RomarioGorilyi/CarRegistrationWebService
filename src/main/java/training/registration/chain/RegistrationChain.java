package training.registration.chain;

import lombok.AllArgsConstructor;
import training.registration.domain.Car;
import training.registration.handler.RegistrationChainHandler;

import java.util.List;
import java.util.ListIterator;

/**
 * @author Roman Horilyi
 */
@AllArgsConstructor
public class RegistrationChain {

    private final ListIterator<RegistrationChainHandler> currentHandlerIterator;
    private final List<RegistrationChainHandler> handlers;

    public RegistrationChain(List<RegistrationChainHandler> handlers) {
        this.handlers = handlers;
        currentHandlerIterator = handlers.listIterator();
    }

    public long proceed(Car car) throws Exception {
        if (!currentHandlerIterator.hasNext())
            return handleEndOfChain();
        RegistrationChainHandler handler = currentHandlerIterator.next();
        try {
            return handler.handle(car, this);
        } finally {
            currentHandlerIterator.previous();
        }
    }

    protected long handleEndOfChain() {
        throw new IllegalStateException("No handler fulfilled the request");
    }
}
