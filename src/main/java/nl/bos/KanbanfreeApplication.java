package nl.bos;

import nl.bos.controllers.MemberController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication(scanBasePackages = {"nl.bos.services"})
@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackageClasses = MemberController.class)
//@ComponentScan(basePackages = "nl.bos.services")
public class KanbanfreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KanbanfreeApplication.class, args);
	}
}
