package be.odisee.brainstorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("be.odisee.brainstorm.domain")
public class BedToewijzingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BedToewijzingApplication.class, args);
	}

}
