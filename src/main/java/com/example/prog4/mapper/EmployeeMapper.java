package com.example.prog4.mapper;

import com.example.prog4.controller.rest.RestEmployee;
import com.example.prog4.model.Employee;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Base64;

@Component
public class EmployeeMapper {

    public Employee toDomain(RestEmployee rest) throws IOException {
        byte[] imageBytes = rest.getPicture().getBytes();
        String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
        return Employee.builder()
                .id(rest.getId())
                .picture(encodedImage)
                .lastName(rest.getLastName())
                .firstName(rest.getFirstName())
                .birthDate(rest.getBirthDate())
                .phoneNumber(rest.getPhoneNumber())
                .CIN(rest.getCIN())
                .address(rest.getAddress())
                .emailPro(rest.getEmailPro())
                .emailPerso(rest.getEmailPerso())
                .position(rest.getPosition())
                .cnapsNumber(rest.getCnapsNumber())
                .sexe(Employee.Sexe.valueOf(rest.getSexe()))
                .build();
    }
}
