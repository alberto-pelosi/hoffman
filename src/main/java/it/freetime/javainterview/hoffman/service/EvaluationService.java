package it.freetime.javainterview.hoffman.service;

import it.freetime.javainterview.hoffman.model.Evaluation;

import it.freetime.javainterview.hoffman.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {

    @Autowired
    EvaluationRepository evaluationRepository;

    public List<Evaluation> findAll(){ return evaluationRepository.findAll(); }

    public Optional<Evaluation> findById(String id){ return evaluationRepository.findById(id); }

    public Evaluation save(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public void deleteById(String id) { evaluationRepository.deleteById(id);}

    public List<Evaluation> findByStudent(String studentName, String studentSurname) {
        return evaluationRepository.findByStudent(studentName, studentSurname);
    }



}
