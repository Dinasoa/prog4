package com.example.prog4.mapper;

import com.example.prog4.controller.rest.RestEmployee;
import com.example.prog4.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class EmployeeMapper {
    public RestEmployee toRest(com.example.prog4.model.Employee domain){
        return RestEmployee.builder()
                .id(domain.getId())
                .birthDate(domain.getBirthDate())
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .build();
    }

    public Employee toDomain(RestEmployee rest) throws IOException {
        return Employee.builder()
                .matricule(rest.getMatricule())
                .picture(rest.getPicture().getBytes())
                .lastName(rest.getLastName())
                .firstName(rest.getFirstName())
                .birthDate(rest.getBirthDate())
                .id(rest.getId())
                .build();
    }
}
