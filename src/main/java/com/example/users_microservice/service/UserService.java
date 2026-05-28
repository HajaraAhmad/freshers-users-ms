package com.example.users_microservice.service;

import com.example.users_microservice.data.User;
import com.example.users_microservice.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        user.setRole("USER");  // default role
        return repo.save(user);
    }

    public String login(String email, String password) {
        User user = repo.findByEmail(email);

        if (user == null) {
            return "User not found";
        }

        if (!user.getPassword().equals(password)) {
            return "Invalid password";
        }

        return "Login successful";
    }

    public String updatePassword(String email, String newPassword) {
        User user = repo.findByEmail(email);

        if (user == null) {
            return "Email not found";
        }

        user.setPassword(newPassword);
        repo.save(user);

        return "Password updated";
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}

