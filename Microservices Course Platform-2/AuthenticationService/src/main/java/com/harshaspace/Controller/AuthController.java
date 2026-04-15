package com.harshaspace.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshaspace.Entity.User;
import com.harshaspace.Repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // Inject the existing bean from SecurityConfig
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
        }

        // Encode password using the injected bean
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        return userRepository.findByUsername(user.getUsername())
            .map(dbUser -> {
                // Use the injected passwordEncoder, do NOT create a new instance
                if (passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
                    return ResponseEntity.ok("Login successful");
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
                }
            })
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found"));
    }
}