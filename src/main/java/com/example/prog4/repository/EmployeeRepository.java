package com.example.prog4.repository;

import com.example.prog4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByFirstNameContainingAndLastNameContainingAndSexeAndPositionContainingAndHiringDateBetweenAndDepartureDateBetween(
            String firstName,
            String lastName,
            Employee.Sexe sex,
            String position,
            String hiringDateStart,
            String hiringDateEnd,
            String departureDateStart,
            String departureDateEnd
    );
}
