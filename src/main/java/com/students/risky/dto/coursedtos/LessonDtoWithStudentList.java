package com.students.risky.dto.coursedtos;

import com.students.risky.dto.BaseEntityDevParams;
import com.students.risky.dto.studentdtos.StudentDtoWithStudentListDto;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class LessonDtoWithStudentList extends BaseEntityDevParams {
    private String lessonName;
    private Set<StudentDtoWithStudentListDto> studentsList = new HashSet<>();
}
