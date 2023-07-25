package com.example.prog4.model;


import jakarta.persistence.*;
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
//    @Column(unique = true)
    private int number;
    private String issueDate;
    private String issuePlace;
}
