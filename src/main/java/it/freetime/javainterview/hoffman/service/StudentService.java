package it.freetime.javainterview.hoffman.service;

import it.freetime.javainterview.hoffman.model.Student;
import it.freetime.javainterview.hoffman.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll() { return studentRepository.findAll(); }

    public Optional<Student> findById(String id){ return studentRepository.findById(id); }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(String id) { studentRepository.deleteById(id);}


}
