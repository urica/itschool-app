package com.itschool.jpa.solid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SPrincipleBefore {
}

class UserRegistration {
    public void registerUser(String username, String email, String password) {
        //Validations
        if (username == null || username.length() < 2) {
            throw new IllegalArgumentException("Username must not be null and should have min 2 chars");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format!");
        }

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

        try {
            //Email sending implementation
        } catch (Exception e) {

        }
    }
}