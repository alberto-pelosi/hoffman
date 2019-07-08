package it.freetime.javainterview.hoffman.controller;

import it.freetime.javainterview.hoffman.model.Student;
import it.freetime.javainterview.hoffman.service.StudentService;
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
public class StudentController {


    @Autowired
    StudentService studentService;

    @RequestMapping(path = "/students", method  = RequestMethod.GET)
    public ModelAndView students() {

        List<Student> allStudents = studentService.findAll();
        ModelAndView mw = new ModelAndView("students");
        mw.addObject("students", allStudents);
        return mw;
    }

    @RequestMapping(path = "/students/{id}", method  = RequestMethod.GET)
    public ModelAndView studentDetail(@PathVariable("id") String id) {

        Optional<Student> s = studentService.findById(id);
        ModelAndView mw = new ModelAndView("student");
        mw.addObject("student", s.get());
        return mw;
    }

    @RequestMapping(path = "/students/add", method  = RequestMethod.GET)
    public ModelAndView addStudent(Student s) {
        ModelAndView mw = new ModelAndView("edit-student");
        mw.addObject("student", s);

        return mw;

    }

    @RequestMapping(path = "/students", method  = RequestMethod.POST)
    public ModelAndView saveQuestion(@Valid Student student, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("edit-student");
        }
        studentService.save(student);
        return new ModelAndView("redirect:/students");

    }

    @RequestMapping(path = "students/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editStudent(@PathVariable(value = "id") String id) {
        ModelAndView mw = new ModelAndView("edit-student");
        mw.addObject("student", studentService.findById(id).get());
        return mw;
    }

    @RequestMapping(path = "students/delete/{id}", method =  RequestMethod.GET)
    public ModelAndView deleteStudent(@PathVariable(value = "id") String id) {
        studentService.deleteById(id);
        return new ModelAndView("redirect:/students");

    }




}
