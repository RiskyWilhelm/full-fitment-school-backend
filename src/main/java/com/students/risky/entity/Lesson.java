package com.students.risky.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id", nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "lesson", unique = true)
    private String lessonName;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "lessonList", cascade=CascadeType.ALL)
    private Set<Student> studentsList = new java.util.LinkedHashSet<>();
}
