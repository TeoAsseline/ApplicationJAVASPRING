package r507.app.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import r507.app.application.accessingdatamysql.Auteur;

@RestController
@SpringBootApplication
public class Application {

	@RequestMapping("/bonjour")
    String home() {
        return "HELLO WORLD - Bonjour le monde !";
    }

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
    model.addAttribute("user", new Auteur());
    return "signup_form";
}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
