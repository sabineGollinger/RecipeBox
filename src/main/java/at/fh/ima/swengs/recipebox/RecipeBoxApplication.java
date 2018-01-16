package at.fh.ima.swengs.recipebox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class RecipeBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeBoxApplication.class, args);
	}
}
