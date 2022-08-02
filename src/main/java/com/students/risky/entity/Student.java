package com.students.risky.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_student_gen")
    @SequenceGenerator(name = "seq_student_gen", sequenceName = "seq_student_gen", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "STUDENT_FIRSTNAME", nullable = false, insertable = false, length = 100)
    private String firstName;
    @Column(name = "STUDENT_LASTNAME", nullable = false, insertable = false, length = 100)
    private String lastName;
    @Column(name = "STUDENT_CLASS", nullable = false, length = 50)
    private String currentClass;

//    private Set<String> classes;


}
