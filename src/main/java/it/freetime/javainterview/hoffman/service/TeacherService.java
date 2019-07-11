package it.freetime.javainterview.hoffman.service;

import it.freetime.javainterview.hoffman.model.Teacher;
import it.freetime.javainterview.hoffman.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> findAll() { return teacherRepository.findAll(); }

    public Optional<Teacher> findById(String id){ return teacherRepository.findById(id); }

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteById(String id) { teacherRepository.deleteById(id);}


}