package com.vipin.usermanagement.service;

import com.vipin.usermanagement.entity.User;
import com.vipin.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveUser(User user) {
        return repository.save(user);

    }
}
