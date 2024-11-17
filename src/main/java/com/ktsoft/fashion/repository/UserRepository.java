package com.ktsoft.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ktsoft.fashion.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
