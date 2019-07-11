package it.freetime.javainterview.hoffman.repository;

import it.freetime.javainterview.hoffman.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentRepository extends MongoRepository<Student, String> {


}
