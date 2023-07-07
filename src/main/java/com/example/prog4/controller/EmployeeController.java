package com.example.prog4.controller;
import com.example.prog4.Model.Employee;
import com.example.prog4.Service.getSessionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EmployeeController {

    private getSessionService getSession;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        List<Employee> employees = getSession.getSessionEmployees(session);
        model.addAttribute("employees", employees);
        model.addAttribute("newEmployee", new Employee());
        return "index";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("newEmployee") Employee newEmployee, HttpSession session) {
        getSession.addEmployee(newEmployee, session);
        return "redirect:/";
    }
}

