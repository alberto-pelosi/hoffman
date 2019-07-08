package it.freetime.javainterview.hoffman.controller;

import it.freetime.javainterview.hoffman.model.Question;
import it.freetime.javainterview.hoffman.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(path = "/questions", method  = RequestMethod.GET)
    public ModelAndView questions() {

        List<Question> allQuestions = questionService.findAll();
        ModelAndView mw = new ModelAndView("questions");
        mw.addObject("questions", allQuestions);
        return mw;
    }

    @RequestMapping(path = "/questions/{id}", method  = RequestMethod.GET)
    public ModelAndView questionDetail(@PathVariable("id") String id) {

        Optional<Question> q = questionService.findById(id);
        ModelAndView mw = new ModelAndView("question");
        mw.addObject("question", q.get());
        return mw;
    }

    @RequestMapping(path = "/questions/add", method  = RequestMethod.GET)
    public ModelAndView addQuestion(Question q) {
        ModelAndView mw = new ModelAndView("edit-question");
        mw.addObject("question", q);

        return mw;

    }

    @RequestMapping(path = "/questions", method  = RequestMethod.POST)
    public ModelAndView saveQuestion(@Valid Question question, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("edit-question");
        }
        questionService.save(question);
        return new ModelAndView("redirect:/questions");

    }

    @RequestMapping(path = "questions/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editProduct(@PathVariable(value = "id") String id) {
        ModelAndView mw = new ModelAndView("edit-question");
        mw.addObject("question", questionService.findById(id).get());
        return mw;
    }

    @RequestMapping(path = "questions/delete/{id}", method =  RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable(value = "id") String id) {
        questionService.deleteById(id);
        return new ModelAndView("redirect:/questions");

    }


}
