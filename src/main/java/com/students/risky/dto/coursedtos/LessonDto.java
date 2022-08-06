package com.students.risky.dto.coursedtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.students.risky.dto.studentdtos.StudentDto;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class LessonDto {
    private String lessonName;
//    @JsonIgnoreProperties("lessonList")
    private Set<StudentDto> studentsList = new HashSet<>();
}
