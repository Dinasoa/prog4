package com.example.prog4.repository;

import com.example.prog4.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepostory extends JpaRepository<Company, Long> {
}
