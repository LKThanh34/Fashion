package com.ktsoft.fashion.service;

import org.springframework.stereotype.Service;

import com.ktsoft.fashion.domain.User;
import com.ktsoft.fashion.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(
        UserRepository userRepository
        ) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user){
        return this.userRepository.save(user);
    }

    
}
