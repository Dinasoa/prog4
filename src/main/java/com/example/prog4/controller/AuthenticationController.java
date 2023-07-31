package com.example.prog4.controller;

import com.example.prog4.controller.viewModel.User;
import com.example.prog4.mapper.UserMapper;
import com.example.prog4.model.Users;
import com.example.prog4.service.AuthService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor
public class AuthenticationController {

    private UserMapper userMapper;
    private AuthService authService;

    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("credentials", new User());
        return "login";
    }

    @PostMapping("authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password, HttpSession session) {
//        authService.authenticate(userMapper.toUserModel(user), session);
//        return "redirect:/employees";
        if (authService.authenticate(username, password)) {
            String sessionId = authService.createSession(username);
            session.setAttribute("sessionId", sessionId);
            return "redirect:/employees"; // Rediriger vers une page protégée après la connexion réussie
        } else {
            return "redirect:/login?error=1"; // Rediriger vers la page de connexion avec un paramètre d'erreur en cas d'échec de l'authentification
        }
    }

    @PostMapping("/logout")
    public String logout (HttpSession session){
        String sessionId = (String) session.getAttribute("sessionId");
        if (sessionId != null) {
            authService.invalidateSession(sessionId);
            session.invalidate();
        }
        return "login";
    }
}
