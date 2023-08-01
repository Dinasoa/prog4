package com.example.prog4.service;

import com.example.prog4.model.Employee;
import com.example.prog4.model.Session;
import com.example.prog4.repository.EmployeeRepository;
import com.example.prog4.repository.SessionRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class AuthService {

    private EmployeeRepository usersRepository;
//    private Map<String, Employee> sessions = new HashMap<>();
    private SessionRepository sessionRepository;

//    public void addUser(Users user) {
//        usersRepository.save(user);
//        createSession(user.getUsername());
//    }
//
//    public Employee getUserByUsername(String username) {
//        return users.stream()
//                .filter(user -> user.getUsername().equals(username))
//                .findFirst()
//                .orElse(null);
//    }

    public boolean authenticate(String username, String password) {
        Employee employee = usersRepository.findByUsernameAndPassword(username, password);
        return employee != null && employee.getPassword().equals(password);
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
//        Employee user = usersRepository.getEmployeeByUsername(username);
        Session session = sessionRepository.save(Session.builder()
                        .id(sessionId)
                        .username(username)
                        .build());
//        sessions.put(sessionId, user);
        return session.getId();
    }

    public boolean isAuthenticated(HttpSession session){
        String sessionId = (String) session.getAttribute("sessionId");
        Session sessions = sessionRepository.findById(sessionId).orElse(null);
        return sessions != null;
    }

    public void invalidateSession(String sessionId) {
        sessionRepository.deleteById(sessionId);
    }

//    public void authenticate(String username, String password, HttpSession session){
//        Employee usersAuthenticated = usersRepository.findByUsernameAndPassword
//                (username,password);
//        if(usersAuthenticated != null){
//            String sessionId = UUID.randomUUID().toString();
//            sessions.(sessionId);
//            session.setAttribute(user.getUsername() + "-session", user);
//        }
//    }
}
