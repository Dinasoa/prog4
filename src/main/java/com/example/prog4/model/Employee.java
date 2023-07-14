package com.example.prog4.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String id;
    private String matricule;
    private String firstName;
    private String lastName;
    private String birthDate;
    @Column(columnDefinition = "text")
    private String picture;
}
