package com.example.prog4.controller.rest;

import com.example.prog4.model.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestEmployee {
    private int id;
    private String matricule;
    private String firstName;
    private String lastName;
    private String birthDate;
    private MultipartFile picture;
    private List<PhoneNumber> phoneNumber;
    private String address;
    private String emailPerso;
    private String emailPro;
    private String CIN;
    private String position;
    private int childrenNumber;
    private String categorieSocioProfessionnelle;
    private int cnapsNumber;
    private String sexe;
}
