package br.dev.diego.events;

import br.dev.diego.events.domain.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventsApplication implements CommandLineRunner {

	@Autowired
	private GroupRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.findAll().forEach(System.out::println);
	}
}
