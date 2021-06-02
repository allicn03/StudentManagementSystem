package org.perscholas.services;

import lombok.extern.java.Log;
import org.perscholas.dao.ICourseRepo;
import org.perscholas.dao.IStudentRepo;
import org.perscholas.models.Course;
import org.perscholas.models.Student;
import org.perscholas.security.AppSecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class StudentService {

    /*
            - add class annotations
            - add @Transactional on class or on each method
            - add crud methods
     */
    private final IStudentRepo studentRepo;

    @Autowired
    public StudentService(IStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    //returns all courses
    public List<Student> getStudents() {
        return studentRepo.findAll();
    } // end of getStudent()

    public Student addNewStudent(Student student) {
        //creates studentOptional and sets it to find student by email
       Optional<Student> studentOptional = studentRepo.findStudentBysEmail(student.getSEmail());
        // check if studentOptional is present and set
       if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken"); // throws error is email is already taken
        }
       //converts password to BCrypt before inserting into database
//       student.setSPass(BCrypt.hashpw(student.getSPass(), BCrypt.gensalt(4)));
        student.setSPass(AppSecurityConfiguration.getPasswordEncoder().encode(student.getSPass()));
        return studentRepo.save(student); //saves the student to the database
   } //end of addNewStudent()

    @Transactional
    public void removeStudent(Long id){
        boolean exists = studentRepo.existsById(id);
        if(exists){
            log.info("student with id " + id + " has been removed");
            studentRepo.deleteById(id);
        }
    }

}


