package cartoes_api.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "cartoes_api.com")
public class CartoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartoesApplication.class, args);
	}

}
