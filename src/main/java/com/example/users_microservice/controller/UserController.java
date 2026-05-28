package com.example.users_microservice.controller;

import com.example.users_microservice.data.User;
import com.example.users_microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return service.login(user.getEmail(), user.getPassword());
    }

    @PutMapping("/password")
    public String updatePassword(@RequestBody User user) {
        return service.updatePassword(user.getEmail(), user.getPassword());
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }
}

