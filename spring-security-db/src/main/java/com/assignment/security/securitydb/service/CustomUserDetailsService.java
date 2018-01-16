package com.assignment.security.securitydb.service;

import com.assignment.security.securitydb.model.CustomUserDetails;
import com.assignment.security.securitydb.model.Users;
import com.assignment.security.securitydb.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 
 * @author Maruthi
 * 
 * Following class is used for USER validation if the authentication is handled 
 * through DB User table
 *
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = usersRepository.findByName(username);

        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers
                .map(CustomUserDetails::new).get();
    }
}
