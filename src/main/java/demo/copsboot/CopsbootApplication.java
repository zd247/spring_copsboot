package demo.copsboot;

import demo.orm.jpa.InMemoryUniqueIdGenerator;
import demo.orm.jpa.UniqueIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class CopsbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CopsbootApplication.class, args);
	}

	/**
	 * this method instantiates, configures, and initializes
	 * a new object to be managed by the Spring IoC container
	 */
	@Bean
	public UniqueIdGenerator<UUID> uniqueIdGenerator () {
		return new InMemoryUniqueIdGenerator();
	}

}
