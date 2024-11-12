package com.itschool.jpa.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.jpa.dtos.CreateUserDto;
import com.itschool.jpa.exceptions.EmailSendingException;
import com.itschool.jpa.exceptions.UserServiceException;
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
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private EmailService emailService;


    public Iterable<User> saveAll(List<User> users) {
        return jpaRepository.saveAll(users);
    }

    public Iterable<User> findAllUsers() {
        return jpaRepository.findAll();
    }

    public void deleteUser(Long id) {
        jpaRepository.deleteById(id);
    }

    public Optional<User> findUserByUsername(String username) {
        return jpaRepository.findByUsername(username);
    }

    public User addUser(User user) {
        //        user.getOrders().forEach(o-> o.setUser(savedUser));
        // Save User
        return jpaRepository.save(user);
    }

    public User createUserFromDto(CreateUserDto userDto) {
//        User u = new User();
//        u.setName(userDto.getName());...
        User user = mapper.convertValue(userDto, User.class);

        User savedUser = jpaRepository.save(user);

        String subject = "Welcome to our service!";
        String body = "Dear " + savedUser.getName() + " Thank you for registration! \n your username is " + savedUser.getUsername();

        try {
            emailService.sendEmail(savedUser.getEmail(), subject, body);
        } catch (EmailSendingException e) {
            System.out.println(e.getMessage());
            throw new UserServiceException("User created successfully, but failed to send welcome email!", "ERROR_ON_MAIL_SENDING");
//            e.printStackTrace();
        }

        return savedUser;
    }
}
