package it.freetime.javainterview.hoffman.repository;

import it.freetime.javainterview.hoffman.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findAll();
}
