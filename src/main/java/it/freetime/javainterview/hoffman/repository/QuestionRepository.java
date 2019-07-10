package it.freetime.javainterview.hoffman.repository;

import it.freetime.javainterview.hoffman.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends MongoRepository<Question, String> {





}
