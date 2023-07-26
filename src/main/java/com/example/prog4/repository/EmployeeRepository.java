package com.example.prog4.repository;

import com.example.prog4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "SELECT * FROM employee " +
            "WHERE (LOWER(last_name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(first_name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR CAST(sexe AS VARCHAR) = :keyword) " +
            "AND (:startDate IS NULL OR hiring_date >= :startDate) " +
            "AND (:endDate IS NULL OR departure_date <= :endDate)",
            nativeQuery = true)
    List<Employee> searchByKeywordAndDateRange(@Param("keyword") String keyword,
                                               @Param("startDate") String startDate,
                                               @Param("endDate") String endDate);


}
