package it.freetime.javainterview.hoffman.repository;

import it.freetime.javainterview.hoffman.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
}
