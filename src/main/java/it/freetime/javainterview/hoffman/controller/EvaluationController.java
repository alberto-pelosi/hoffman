package it.freetime.javainterview.hoffman.controller;

import it.freetime.javainterview.hoffman.model.Evaluation;
import it.freetime.javainterview.hoffman.model.Student;
import it.freetime.javainterview.hoffman.service.EvaluationService;
import it.freetime.javainterview.hoffman.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;

    @Autowired
    StudentService studentService;

    @RequestMapping(path = "/evaluations", method  = RequestMethod.GET)
    public ModelAndView evaluations() {

        List<Evaluation> allEvaluations = evaluationService.findAll();
        ModelAndView mw = new ModelAndView("evaluations");
        mw.addObject("evaluations", allEvaluations);
        return mw;
    }

    @RequestMapping(path = "/evaluations/{id}", method  = RequestMethod.GET)
    public ModelAndView evaluationDetail(@PathVariable("id") String id) {

        Optional<Evaluation> e = evaluationService.findById(id);
        ModelAndView mw = new ModelAndView("evaluation");
        mw.addObject("evaluation", e.get());
        return mw;
    }

    @RequestMapping(path = "/evaluations/add", method  = RequestMethod.GET)
    public ModelAndView addEvaluation() {
        Evaluation ef = new Evaluation();
        List<Student> students = studentService.findAll();

        ModelAndView mw = new ModelAndView("edit-evaluation");
        mw.addObject("evaluation", ef);
        mw.addObject("students", students);

        return mw;

    }

    @RequestMapping(path = "/evaluations", method  = RequestMethod.POST)
    public ModelAndView saveEvaluation(@Valid Evaluation evaluation, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<Student> students = studentService.findAll();
            ModelAndView mw = new ModelAndView("edit-evaluation");
            mw.addObject("students", students);
            return mw;

        }
        evaluationService.save(evaluation);
        return new ModelAndView("redirect:/evaluations");

    }

    @RequestMapping(path = "evaluations/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editEvaluation(@PathVariable(value = "id") String id) {
        ModelAndView mw = new ModelAndView("edit-evaluation");
        List<Student> students = studentService.findAll();
        mw.addObject("evaluation", evaluationService.findById(id).get());
        mw.addObject("students", students);
        return mw;
    }

    @RequestMapping(path = "evaluations/delete/{id}", method =  RequestMethod.GET)
    public ModelAndView deleteEvaluation(@PathVariable(value = "id") String id) {
        evaluationService.deleteById(id);
        return new ModelAndView("redirect:/evaluations");

    }


}
