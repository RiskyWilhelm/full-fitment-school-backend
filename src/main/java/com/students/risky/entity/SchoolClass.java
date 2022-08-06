package com.students.risky.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@Entity(name = "schoolclasses")
@NoArgsConstructor
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id", nullable = false)
    private Long id;

    @Column(name = "className", nullable = false, unique = true, length = 50)
    private String className;

    @Column(name = "studentCount")
    private byte studentCount = 0;

    @OneToOne
    @JoinColumn(name = "responsibleTeacherId", unique = true)
    @JsonBackReference
    private Teacher responsibleTeacher;

    @OneToMany(mappedBy = "currentClass")
    @JsonManagedReference
    private List<Student> studentList = new ArrayList<>();

    public SchoolClass(Long id) {
        this.id = id;
    }
}
