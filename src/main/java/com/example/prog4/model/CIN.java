package com.example.prog4.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class CIN {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number;
    private String issueDate;
    private String issuePlace;
}
