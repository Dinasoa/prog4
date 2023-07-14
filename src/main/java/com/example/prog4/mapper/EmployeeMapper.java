package com.example.prog4.mapper;

import com.example.prog4.controller.rest.RestEmployee;
import com.example.prog4.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Component
public class EmployeeMapper {
    public RestEmployee toRest(com.example.prog4.model.Employee domain){
        return RestEmployee.builder()
                .id(domain.getId())
                .birthDate(domain.getBirthDate())
                .firstName(domain.getFirstName())
                .lastName(domain.getLastName())
                .matricule(domain.getMatricule())
                .build();
    }

    public Employee toDomain(RestEmployee rest) throws IOException {
        byte[] imageBytes = rest.getPicture().getBytes();
        String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
        return Employee.builder()
                .picture(encodedImage)
                .lastName(rest.getLastName())
                .firstName(rest.getFirstName())
                .birthDate(rest.getBirthDate())
                .id(rest.getId())
                .build();
    }
}
