package com.itschool.jpa.solid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SPrincipleAfter {
}

class UserValidation {
    public void validation(String username, String email, String password) {
        if (username == null || username.length() < 2) {
            throw new IllegalArgumentException("Username must not be null and should have min 2 chars");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format!");
        }
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters!");
        }
    }
}

class UserRepository {
    public void saveUser(String username, String email, String password) {
        try (Connection connection = DriverManager.getConnection("bla bal")) {
            String sql = "insert into users (username, email, password) values (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

class EmailService {
    public void sendWelcomeEmail(String username, String email) {
        try {
            //Email sending implementation
        } catch (Exception e) {

        }
    }
}

class UserRegistrationService {
    private UserValidation userValidation;
    private UserRepository userRepository;
    private EmailService emailService;

    public UserRegistrationService(UserValidation userValidation, UserRepository userRepository, EmailService emailService) {
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.userValidation = userValidation;
    }

    public void registrationUser(String username, String email, String password) {
        //validation
        userValidation.validation(username, email, password);

        //save in DB
        userRepository.saveUser(username, email, password);

        //send email
        emailService.sendWelcomeEmail(username, email);
    }
}
