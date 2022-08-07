package com.students.risky.dto.studentdtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.students.risky.dto.BaseEntityNicknames;
import com.students.risky.dto.coursedtos.LessonDto;
import com.students.risky.dto.schoolclassdtos.SchoolClassDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class StudentDto extends BaseEntityNicknames {
    /*private String firstName;
    private String lastName;*/
    private SchoolClassDto currentClass;
    @JsonIgnoreProperties("studentsList")
    private Set<LessonDto> lessonList = new java.util.LinkedHashSet<>();
}
