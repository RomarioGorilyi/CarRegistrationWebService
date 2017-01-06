package training.registration.exception;

/**
 * @author Roman Horilyi
 */
public class CarRegistrationException extends Exception {

    public CarRegistrationException() {
        super("Car registration exception.");
    }

    public CarRegistrationException(Throwable cause) {
        super("Car registration exception is caused by:\n" + cause.toString());
    }

    public CarRegistrationException(String message) {
        super(message);
    }

    public CarRegistrationException(String message, Exception e) {
        super(message + "\n" + e.getMessage());
    }
}
