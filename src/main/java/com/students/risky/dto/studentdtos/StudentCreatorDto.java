package com.students.risky.dto.studentdtos;

import com.students.risky.entity.SchoolClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCreatorDto {
    private String firstName;
    private String lastName;
    private SchoolClass currentClass;
}
