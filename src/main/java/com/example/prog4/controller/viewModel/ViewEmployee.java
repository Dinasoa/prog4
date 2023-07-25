package com.example.prog4.controller.viewModel;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewEmployee {
    private int id;
    private String matricule;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String picture;
    private String phoneNumber;
    private String address;
    private String emailPerso;
    private String emailPro;
    private int CINNumber;
    private String CINPLace;
    private String CINDate;
    private String position;
    private int childrenNumber;
    private String CSP;
    private int cnapsNumber;
    private String hiringDate;
    private String departureDate;
    private String sexe;
}
