package it.freetime.javainterview.hoffman;

import it.freetime.javainterview.hoffman.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HoffmanApplication {

	@Autowired
	private QuestionRepository questionRepository;

	public static void main(String[] args) {
		SpringApplication.run(HoffmanApplication.class, args);
	}


}
