package com.tunitechlabs.gestionetudiant.student;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_STUDENT")
    @SequenceGenerator(name = "SEQUENCE_STUDENT", sequenceName = "students_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private int age;
}
