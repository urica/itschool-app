package com.itschool.jpa.services;

import com.itschool.jpa.models.User;
import com.itschool.jpa.repositories.UserJpaRepository;
import com.itschool.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserJpaRepository jpaRepository;

    public Iterable<User> saveAll(List<User> users) {
        return repository.saveAll(users);
    }

    public Iterable<User> findAllUsers() {
        return repository.findAll();
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public Optional<User> findUserByUsername(String username) {
        return jpaRepository.findByUsername(username);
    }

    public User addUser(User user) {
        // Save User
        return jpaRepository.save(user);
    }
}
