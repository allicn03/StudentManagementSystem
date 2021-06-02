package org.perscholas.security;

import org.perscholas.dao.IAuthGroupRepo;
import org.perscholas.dao.IStudentRepo;
import org.perscholas.models.AuthGroup;
import org.perscholas.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserDetailService implements UserDetailsService {

    //establish repos
    private final IStudentRepo studentRepo;
    private final IAuthGroupRepo authGroupRepo;

    //constructor
    @Autowired
    public AppUserDetailService(IStudentRepo studentRepo, IAuthGroupRepo authGroupRepo) {
        this.studentRepo = studentRepo;
        this.authGroupRepo = authGroupRepo;
    }

    //load by username
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Student> student = studentRepo.findBysName(s);
        if(student.isEmpty())
            throw new UsernameNotFoundException("Cannot find Username: " + s);
        List<AuthGroup> authGroups = this.authGroupRepo.findByaUsername(s);
        return new AppUserPrincipal(student.get(),authGroups);
    }
}
