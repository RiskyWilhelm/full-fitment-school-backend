package com.students.risky.dto.studentdtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.students.risky.dto.schoolclassdtos.SchoolClassWithStudentListDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentDtoWithStudentListDto {
    private String firstName;
    private String lastName;
    //    Jsonbackreference sonsuz aratma sorunu reference yardımıyla cozuyor
    @JsonBackReference
    private SchoolClassWithStudentListDto currentClass;
}
