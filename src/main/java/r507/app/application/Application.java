package r507.app.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

	@RequestMapping("/bonjour")
    String home() {
        return "HELLO WORLD - Bonjour le monde !";
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
