package com.example.prog4.service;

import com.example.prog4.model.Company;
import com.example.prog4.repository.CompanyRepostory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {
    private CompanyRepostory companyRepostory;

    public List<Company> getCompanies(){
        return companyRepostory.findAll();
    }

    public Company saveCompany(Company company){
        return companyRepostory.save(company);
    }
}
