package org.perscholas.controllers;

import org.perscholas.models.Course;
import org.perscholas.models.Student;
import org.perscholas.services.CourseService;
import org.perscholas.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("console")
public class AdminController {

    StudentService studentService;
    CourseService courseService;

    @Autowired
    public AdminController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping("/showstudents")
    public String showStudents(@ModelAttribute("student") @Valid Student student, BindingResult result, Model model ){

        List<Student> s = studentService.getStudents();
        model.addAttribute("studentTemp", s);
        System.out.println(s);

        return "displaystudents";
    }

    @GetMapping("/showcourses")
    public String getCourses(@ModelAttribute("course") @Valid Course course, BindingResult result, Model model ){
        //prints out any errors - "in a british accent"
        System.out.println(result.hasErrors());
        if(!result.hasErrors()) {
            List<Course> c = courseService.getCourses();
            model.addAttribute("courseTemp", c);
            System.out.println(c);
        }
        return "displaycourses";
    }

    @GetMapping("/getstudentbyemail")
    public String getStudentBysEmail(){

        return "getstudentbyemail";
    }

    @PostMapping("/delete/{studentId}")
    public String removeStudent(@PathVariable("studentId") Long id){
        studentService.removeStudent(id);
        return "removed";
    }

    @PostMapping("/deletecourse/{studentId}")
    public String removeCourse(@PathVariable("courseId") Long id){
        courseService.removeCourse(id);
        return "removed";
    }

//    @PreAuthorize("hasAuthority('READ')")
//    @GetMapping("/getstudentbyid")
//    public String getStudentById(){
//
//        return "getstudentbyid";
//    }
}