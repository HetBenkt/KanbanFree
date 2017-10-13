package nl.bos;

import nl.bos.models.Board;
import nl.bos.models.Member;
import nl.bos.repositories.IBoardRepository;
import nl.bos.repositories.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication(scanBasePackages = {"nl.bos.services", "nl.bos.controllers", "nl.bos.repositories", "nl.bos.config", "nl.bos.components"})
public class KanbanfreeApplication {

	@Autowired
	protected InMemoryUserDetailsManager inMemoryUserDetailsManager;

	public static void main(String[] args) {
		SpringApplication.run(KanbanfreeApplication.class, args);
	}

	@Bean
	CommandLineRunner initDate(IMemberRepository memberRepo, IBoardRepository boardRepo) {
		return args -> {
			Member testUser = new Member("testuser", "admin", "user", "test", "user", "test.user@local.com");
			memberRepo.save(testUser);
			addInMemorySecurity(testUser);
			Board testUserBoard1 = new Board("My first board", testUser);
			Board testUserBoard2 = new Board("My second board", testUser);
			boardRepo.save(testUserBoard1);
			boardRepo.save(testUserBoard2);

			Member testAdmin = new Member("testadmin", "admin", "admin", "test", "admin", "test.admin@local.com");
			memberRepo.save(testAdmin);
			addInMemorySecurity(testAdmin);
		};
	}

	private void addInMemorySecurity(Member member) {
		final Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(String.format("ROLE_%s", member.getRole().toUpperCase())));
		inMemoryUserDetailsManager.createUser(new User(member.getNickName(), member.getPassword(), grantedAuthorities));
	}

}
