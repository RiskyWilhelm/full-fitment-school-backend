package com.students.risky.dto.coursedtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.students.risky.dto.BaseEntityDevParams;
import com.students.risky.dto.studentdtos.StudentDto;
import com.students.risky.dto.studentdtos.StudentDtoWithStudentListDto;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class LessonDtoWithStudentList extends BaseEntityDevParams {
    private String lessonName;
//    NORMAL ONE
//    private Set<StudentDtoWithStudentListDto> studentsList = new HashSet<>();
    @JsonIgnoreProperties({"lessonList"})
    private Set<StudentDto> studentsList = new HashSet<>();
}
