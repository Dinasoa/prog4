package com.example.prog4.controller;

import com.example.prog4.controller.viewModel.CreateEmployee;
import com.example.prog4.controller.viewModel.ViewEmployee;
import com.example.prog4.mapper.EmployeeMapper;
import com.example.prog4.model.Employee;
import com.example.prog4.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@Slf4j
public class EmployeeController {
    private EmployeeService service;
    private EmployeeMapper mapper;

    @GetMapping("/")
    public String index(Model model) {
        List<Employee> employees = service.getAllEmployees();
        List<ViewEmployee> viewEmployees = service.getAllEmployees()
                .stream().map(employee -> mapper.toViewEmployee(employee)).toList();
        List<String> categoriesList = service.getAllCSP();

        model.addAttribute("categoriesList", categoriesList);
        model.addAttribute("employees", viewEmployees);
        model.addAttribute("newEmployee", new CreateEmployee());
        return "index";
    }


    @PostMapping("/addEmployee")
    public String addEmployee(Model model, @ModelAttribute("newEmployee") CreateEmployee newEmployee) throws IOException {
        service.createEmployee(mapper.toDomain(newEmployee));
        model.addAttribute("newEmployee", new CreateEmployee());
        return "redirect:/";
    }

    @GetMapping("/employees/{id}/edit")
    public String editEmployee(@PathVariable("id") Integer id, Model model) {
        CreateEmployee employee = mapper.toCreateEmployee(service.getById(id));
        model.addAttribute("employee", employee);
        return "editEmployee";
    }

    @PostMapping("/employees/{id}/edit")
    public String updateEmployee(Model model, @PathVariable("id") Integer id, @ModelAttribute("employee") CreateEmployee updatedEmployee) throws IOException {
        service.createEmployee(mapper.toDomain(updatedEmployee));
        model.addAttribute("newEmployee", new CreateEmployee());
        return "redirect:/";
    }


    @GetMapping("/employee-informations/{id}")
    public String getEmployeeById(Model model, @PathVariable Integer id){
        if(id != null){
        ViewEmployee employee =  mapper.toViewEmployee(service.getById(id));
         model.addAttribute("employee", employee);
        }
        return "ficheEmployee";
    }
}

