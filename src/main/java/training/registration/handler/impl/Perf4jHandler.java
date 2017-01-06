package training.registration.handler.impl;

import training.registration.chain.RegistrationChain;
import training.registration.domain.Car;
import training.registration.handler.RegistrationChainHandler;
import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * @author Roman Horilyi
 */
public class Perf4jHandler implements RegistrationChainHandler {

    /**
     * By using different tag attribute values you might create several copies of this handler
     * and monitor different parts of the chain
     */
    private String tag;

    @PostConstruct
    public void init() {
        if (StringUtils.isEmpty(tag)) {
            tag = Perf4jHandler.class.getName();
        }
    }

    @Override
    public long handle(Car car, RegistrationChain chain) throws Exception {
        StopWatch watch = new Slf4JStopWatch(tag);
        try {
            return chain.proceed(car);
        } finally {
            watch.stop();
        }
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
