package com.example.prog4.controller;

import com.example.prog4.controller.rest.RestEmployee;
import com.example.prog4.mapper.EmployeeMapper;
import com.example.prog4.model.Employee;
import com.example.prog4.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService service;
    private EmployeeMapper mapper;

    @GetMapping("/")
    public String index(Model model) {
        List<RestEmployee> employees = service.getAllEmployees()
                .stream().map(employee -> mapper.toRest(employee)).collect(Collectors.toList());
        model.addAttribute("employees", employees);
        model.addAttribute("newEmployee", new Employee());
        return "index";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("newEmployee") RestEmployee newEmployee) throws IOException {
        service.createEmployee(mapper.toDomain(newEmployee));
        return "redirect:/";
    }
}

