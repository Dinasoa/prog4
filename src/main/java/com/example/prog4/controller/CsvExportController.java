package com.example.prog4.controller;
import com.example.prog4.controller.viewModel.ViewEmployee;
import com.example.prog4.mapper.EmployeeMapper;
import com.example.prog4.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CsvExportController {

    private EmployeeMapper employeeMapper;
    private final EmployeeService employeeService;

    public CsvExportController(EmployeeMapper employeeMapper, EmployeeService employeeService) {
        this.employeeMapper = employeeMapper;
        this.employeeService = employeeService;
    }

    @GetMapping("/export-to-csv")
    public void exportToCsv(HttpServletResponse response) throws IOException {
        // Setting the response content type to CSV
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"employees.csv\"");

        // Get the list of employees from the service
        List<ViewEmployee> employees = employeeService.getAllEmployees().stream()
                .map(employee -> employeeMapper.toViewEmployee(employee)).toList();

        // Create a CSV writer
        PrintWriter writer = response.getWriter();

        // Write employee employees to CSV
        for (ViewEmployee employee : employees) {
            writer.println(employeeToCsvString(employee));
        }

        // Close the writer
        writer.flush();
        writer.close();
    }

    // Helper method to convert an Employee object to a CSV string
    private List<String> employeeToCsvString(ViewEmployee employee) {
        // Format the employees to CSV string, you may need to modify this depending on the actual employees types

        List<String> employees = new ArrayList<>();
        employees.add("Matricule: " + employee.getMatricule());
        employees.add("FirstName: " + employee.getFirstName());
        employees.add("LastsName: " + employee.getLastName());
        employees.add("BirthDate: " + employee.getBirthDate());
        employees.add("Address: " + employee.getAddress());
        employees.add("Position: " + employee.getPosition());
        employees.add("Hiring Date: " + employee.getHiringDate());
        employees.add("Email Perso: " + employee.getEmailPerso());
        employees.add("Email Pro: " + employee.getEmailPro());

        return employees;

    }
}
