package com.example.billhistory.controller;

import com.example.billhistory.entity.Student;
import com.example.billhistory.service.AuthService;
import com.example.billhistory.repository.StudentRepository;
import com.example.billhistory.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private StudentRepository studentRepository; // Inject StudentRepository to fetch studentId

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if (authService.validateCredentials(username, password)) {
            // Fetch the student entity using the username
            Student student = studentRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Generate the JWT token
            String token = jwtUtil.generateToken(username);

            // Include studentId in the response
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("studentId", student.getId()); // Add studentId to response

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
