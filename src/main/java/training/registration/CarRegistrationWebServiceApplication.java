package training.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CarRegistrationWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRegistrationWebServiceApplication.class, args);
	}
}
