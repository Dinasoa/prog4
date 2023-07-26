package com.example.prog4.service;

import com.example.prog4.model.Employee;
import com.example.prog4.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository repository;
    public Employee createEmployee(Employee employee){
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public Employee getById(Integer id){
        return repository.findById(id).get();
    }

    public List<Employee> getFilteredEmployees(
            String firstName,
            String lastName,
            Employee.Sexe sex,
            String position,
            String hiringDateStart,
            String hiringDateEnd,
            String departureDateStart,
            String departureDateEnd
    ) {
        return repository.findAllByFirstNameContainingAndLastNameContainingAndSexeAndPositionContainingAndHiringDateBetweenAndDepartureDateBetween(
                firstName,
                lastName,
                sex,
                position,
                hiringDateStart,
                hiringDateEnd,
                departureDateStart,
                departureDateEnd
        );
    }

    public List<Employee> searchByKeyword(String keyword) {
        return repository.searchByKeyword(keyword);
    }

    public List<String> getAllCSP(){
        List<String> CSP = new ArrayList<>();
        CSP.add("AGRICULTURAL_WORKERS");
        CSP.add("CRAFTSMEN_AND_ARTISANS");
        CSP.add("TRADERS_AND_MERCHANTS");
        CSP.add("CIVIL_SERVANTS_AND_PROFESSIONALS");
        CSP.add("UNSKILLED_LABORERS");
        return CSP;
    }

    public List<Employee> sort(String sortOrder, String atr) {
        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(atr).ascending() :
                Sort.by(atr).descending();

        return repository.findAll(sort);
    }
}
