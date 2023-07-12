package com.example.prog4.service;

import com.example.prog4.model.Employee;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

public class getSessionService {
    public static List<Employee> getSessionEmployees(HttpSession session) {
        List<Employee> employees = (List<Employee>) session.getAttribute("employees");
        if (employees == null) {
            employees = new ArrayList<>();
            session.setAttribute("employees", employees);
        }
        return employees;
    }

    public static void addEmployee(@ModelAttribute("newEmployee") Employee newEmployee, HttpSession session){
        List<Employee> employees = getSessionEmployees(session);
        employees.add(newEmployee);
        session.setAttribute("employees", employees);
    }
}
