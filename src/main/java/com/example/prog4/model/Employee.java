package com.example.prog4.model;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(columnDefinition = "text")
    private String picture;
    @OneToMany
    private List<PhoneNumber> phoneNumber;
    private String address;
    private String emailPerso;
    private String emailPro;
    private String CIN;
    private String position;
    private int childrenNumber;
    @ManyToOne
    private CategorySocioProfesional categorieSocioProfesional;
    private int cnapsNumber;
    private Sexe sexe;

    public enum Sexe{
        H,F;
    }
}
