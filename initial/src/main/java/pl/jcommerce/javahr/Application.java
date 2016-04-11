package pl.jcommerce.javahr;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	@Bean
	CommandLineRunner init(PersonRepository personRepository) {
		return (evt) -> Arrays.asList(
				new Person("Tomecki", "Tomek"), new Person("Marek", "Jurek"), new Person("Adam", "Bien"))
				.forEach(
						a -> {
							personRepository.save(a);
						});
	}
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

}
