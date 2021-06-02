package org.perscholas.services;

import org.perscholas.dao.IStudentRepo;
import org.perscholas.models.Student;

import java.util.Optional;

public class AdminService {

    private final IStudentRepo studentRepo;


    public AdminService(IStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Optional<Student> getStudentBysEmail(String email){
        //creates studentOptional and sets it to find student by email
        Optional<Student> s = studentRepo.findStudentBysEmail(email);

        return s;
    }
}
