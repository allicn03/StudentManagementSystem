package org.perscholas;

import lombok.extern.java.Log;
import org.perscholas.dao.IAuthGroupRepo;
import org.perscholas.dao.IStudentRepo;
import org.perscholas.models.AuthGroup;
import org.perscholas.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Log
@Transactional
public class AppStartupRunner implements CommandLineRunner {

    IAuthGroupRepo authGroupRepo;
    IStudentRepo studentRepo;

    @Autowired
    public AppStartupRunner(IAuthGroupRepo authGroupRepo, IStudentRepo studentRepo) {
        this.authGroupRepo = authGroupRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public void run(String... args) throws Exception {

//        authGroupRepo.save(new AuthGroup("erik", "ROLE_ADMIN"));
//        authGroupRepo.save(new AuthGroup("erik", "ROLE_STUDENT"));
//        authGroupRepo.save(new AuthGroup("erik", "WRITE"));
//        authGroupRepo.save(new AuthGroup("erik", "READ"));
//        authGroupRepo.save(new AuthGroup("erik", "UPDATE"));
//        authGroupRepo.save(new AuthGroup("erik", "DELETE"));
//        authGroupRepo.save(new AuthGroup("dean", "ROLE_STUDENT"));
//        authGroupRepo.save(new AuthGroup("dean", "ROLE_ADMIN"));
//        authGroupRepo.save(new AuthGroup("dean", "READ"));
//        authGroupRepo.save(new AuthGroup("test", "ROLE_STUDENT"));
//        authGroupRepo.save(new AuthGroup("student_two", "ROLE_STUDENT"));
//        authGroupRepo.save(new AuthGroup("student_three", "ROLE_STUDENT"));
    }
}
