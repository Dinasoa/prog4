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
        List<Employee> employees = service.getAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("newEmployee", new Employee());
        return "index";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("newEmployee") RestEmployee newEmployee) throws IOException {
        service.createEmployee(mapper.toDomain(newEmployee));
        return "redirect:/";
    }

    @GetMapping("/employee-details/{id}")
    public String getEmployeeById(Model model, @PathVariable Integer id){
        if(id != null){
        Employee employee =  service.getById(id);
         model.addAttribute("employee", employee);
        }
        return "ficheEmployee";
    }
}

