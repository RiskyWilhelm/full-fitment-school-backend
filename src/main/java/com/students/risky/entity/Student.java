package com.students.risky.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long id;

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 100)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currentclass_id")
    @JsonBackReference
    private SchoolClass currentClass;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    //Ders sınıfına ManyToMany ile bağlandı.
    @JoinTable(name= "student_lesson",
            joinColumns={@JoinColumn(name= "student_id", referencedColumnName = "student_id")},
            inverseJoinColumns={@JoinColumn(name= "lesson_id", referencedColumnName = "lesson_id")})
    private Set<Lesson> lessonList = new java.util.LinkedHashSet<>();

    public void addLesson(Lesson lesson){
        this.lessonList.add(lesson);
    }

}
