package it.freetime.javainterview.hoffman.repository;

import it.freetime.javainterview.hoffman.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface QuestionRepository extends MongoRepository<Question, String> {





}
