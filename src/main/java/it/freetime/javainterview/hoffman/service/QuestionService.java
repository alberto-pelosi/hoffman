package it.freetime.javainterview.hoffman.service;


import it.freetime.javainterview.hoffman.model.Question;
import it.freetime.javainterview.hoffman.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> findAll(){ return questionRepository.findAll(); }

    public Optional<Question> findById(String id){ return questionRepository.findById(id); }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public void deleteById(String id) { questionRepository.deleteById(id);}



}
