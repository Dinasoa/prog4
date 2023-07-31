package com.example.prog4.service;

import com.example.prog4.model.Users;
import com.example.prog4.repository.UsersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class AuthService {

    private UsersRepository usersRepository;

    private List<Users> users = new ArrayList<>();
    private Map<String, Users> sessions = new HashMap<>();

    public void addUser(Users user) {
        usersRepository.save(user);
        createSession(user.getUsername());
    }

    public Users getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public boolean authenticate(String username, String password) {
        Users user = usersRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        Users user = getUserByUsername(username);
        sessions.put(sessionId, user);
        return sessionId;
    }

    public Users getUserBySessionId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }
    public void authenticate(Users user, HttpSession session){
        Users usersAuthenticated = usersRepository.findByUsernameAndPassword
                (user.getUsername(),user.getPassword());
        if(usersAuthenticated != null){
            String sessionId = UUID.randomUUID().toString();
            usersAuthenticated.setSessionId(sessionId);
            session.setAttribute(user.getUsername() + "-session", user);
        }
    }
}
