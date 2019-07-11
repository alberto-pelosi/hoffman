package it.freetime.javainterview.hoffman.repository;

import it.freetime.javainterview.hoffman.model.Evaluation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EvaluationRepository extends MongoRepository<Evaluation, String> {


    @Query("{'$and' : [{'student.name' : {$eq: ?0}}, {'student.surname': {$eq: ?1}}]}")
    public List<Evaluation> findByStudent(String name, String surname);


}
