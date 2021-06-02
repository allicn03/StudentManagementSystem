package org.perscholas.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("console")
public class AdminController {
    @GetMapping("/showstudents")
    public String getUsers(Model model){

        return "displaystudents";
    }

    @GetMapping("/showcourses")
    public String getCourses(Model model){

        return "displaycourses";
    }

    @GetMapping("/getstudentbyemail")
    public String getStudentBysEmail(){

        return "getstudentbyemail";
    }

//    @PreAuthorize("hasAuthority('WRITE')")
//    @GetMapping("/getstudentbyid")
//    public String getStudentById(){
//
//        return "getstudentbyid";
//    }
}