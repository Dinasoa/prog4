package com.example.prog4.controller.viewModel;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewEmployee {
    private String matricule;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String picture;
    private String phoneNumber;
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
