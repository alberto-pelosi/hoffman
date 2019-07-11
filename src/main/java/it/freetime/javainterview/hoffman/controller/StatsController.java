package it.freetime.javainterview.hoffman.controller;

import it.freetime.javainterview.hoffman.model.Evaluation;
import it.freetime.javainterview.hoffman.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class StatsController {


    @Autowired
    EvaluationService evaluationService;


    @RequestMapping(path = "/stats", method  = RequestMethod.GET)
    public ModelAndView evalutaionsByDate() {

        List<Evaluation> allEvalutaions = evaluationService.findAllSortedByDate();
        ModelAndView mw = new ModelAndView("stats");
        mw.addObject("stats", allEvalutaions);

        return mw;
    }


}
