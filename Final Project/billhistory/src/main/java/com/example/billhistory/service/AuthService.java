package com.example.billhistory.service;

import com.example.billhistory.entity.Student;
import com.example.billhistory.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private StudentRepository studentRepository;

    public boolean validateCredentials(String username, String password) {
        return studentRepository.findByUsername(username)
                .map(student -> student.getPassword().equals(password))
                .orElse(false);
    }
}
