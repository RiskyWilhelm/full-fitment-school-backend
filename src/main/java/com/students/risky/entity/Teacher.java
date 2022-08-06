package com.students.risky.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", nullable = false)
    private Long id;
    @Column(name = "firstname", nullable = false, length = 100)
    private String firstName;
    @Column(name = "lastname", nullable = false, length = 100)
    private String lastName;

    @OneToOne(mappedBy = "responsibleTeacher")
    @JsonManagedReference
    private SchoolClass responsibleClass;

    public Teacher(Long id) {
        this.id = id;
    }

    //    DERS OGRETMEN ILISKISI
    /*@Column(name = "branch")
    private String branch;*/
}
