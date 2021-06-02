package org.perscholas.security;

import org.perscholas.models.AuthGroup;
import org.perscholas.models.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class AppUserPrincipal implements UserDetails {

    //establish student object and auth group
    private Student student;
    private List<AuthGroup> authGroups;

    //constructor
    public AppUserPrincipal(Student student, List<AuthGroup> authGroups) {
        this.student = student;
        this.authGroups = authGroups;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //if null return empty
        if(null == authGroups){
            return Collections.emptySet();
        }
        //establish new set of simple granted authorities
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        //add each auth group for the user
        authGroups.forEach(authGroup -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(authGroup.getAAuthGroup()));
        });
        return grantedAuthorities;

    }

    @Override
    public String getPassword() {
        return this.student.getSPass();
    }

    @Override
    public String getUsername() {
        return this.student.getSName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
