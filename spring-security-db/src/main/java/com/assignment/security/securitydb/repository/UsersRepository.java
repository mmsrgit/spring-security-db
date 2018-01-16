package com.assignment.security.securitydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.security.securitydb.model.Users;

import java.util.Optional;

/**
 * 
 * @author Maruthi
 *
 */

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
