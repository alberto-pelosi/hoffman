package it.freetime.javainterview.hoffman.controller;

import it.freetime.javainterview.hoffman.model.Teacher;
import it.freetime.javainterview.hoffman.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(path = "/teachers", method  = RequestMethod.GET)
    public ModelAndView teachers() {

        List<Teacher> allTeachers = teacherService.findAll();
        ModelAndView mw = new ModelAndView("teachers");
        mw.addObject("teachers", allTeachers);
        return mw;
    }

    @RequestMapping(path = "/teachers/{id}", method  = RequestMethod.GET)
    public ModelAndView tracherDetail(@PathVariable("id") String id) {

        Optional<Teacher> t = teacherService.findById(id);
        ModelAndView mw = new ModelAndView("teacher");
        mw.addObject("teacher", t.get());
        return mw;
    }

    @RequestMapping(path = "/teachers/add", method  = RequestMethod.GET)
    public ModelAndView addTeacher(Teacher t) {
        ModelAndView mw = new ModelAndView("edit-teacher");
        mw.addObject("teacher", t);

        return mw;

    }

    @RequestMapping(path = "/teachers", method  = RequestMethod.POST)
    public ModelAndView saveTeacher(@Valid Teacher teacher, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("edit-teacher");
        }
        teacherService.save(teacher);
        return new ModelAndView("redirect:/teachers");

    }

    @RequestMapping(path = "teachers/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editTeacher(@PathVariable(value = "id") String id) {
        ModelAndView mw = new ModelAndView("edit-teacher");
        mw.addObject("teacher", teacherService.findById(id).get());
        return mw;
    }

    @RequestMapping(path = "teachers/delete/{id}", method =  RequestMethod.GET)
    public ModelAndView deleteTeacher(@PathVariable(value = "id") String id) {
        teacherService.deleteById(id);
        return new ModelAndView("redirect:/teachers");

    }

}
