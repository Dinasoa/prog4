package com.example.prog4.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String matricule;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String hiringDate;
    private String departureDate;
    @Column(columnDefinition = "text")
    private String picture;
    @OneToMany
    private List<PhoneNumber> phoneNumber;
    private String address;
    private String emailPerso;
    private String emailPro;
    @OneToOne
    private CIN CIN;
    private String position;
    private int childrenNumber;
    private CSP categorieSocioProfesional;
    private int cnapsNumber;
    private Sexe sexe;
    private String username;
    private String password;
    public enum Sexe{
        H,F;
    }
    public enum CSP {
        AGRICULTURAL_WORKERS,
        CRAFTSMEN_AND_ARTISANS,
        TRADERS_AND_MERCHANTS,
        CIVIL_SERVANTS_AND_PROFESSIONALS,
        UNSKILLED_LABORERS;
    }
}
