package it.freetime.javainterview.hoffman.repository;

import it.freetime.javainterview.hoffman.model.Evaluation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EvaluationRepository extends MongoRepository<Evaluation, String> {

    List<Evaluation> findAll();

    Optional<Evaluation> findById(String id);
}
