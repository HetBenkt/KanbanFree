package nl.bos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"nl.bos.services", "nl.bos.controllers", "nl.bos.repositories"})
public class KanbanfreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KanbanfreeApplication.class, args);
	}
}
