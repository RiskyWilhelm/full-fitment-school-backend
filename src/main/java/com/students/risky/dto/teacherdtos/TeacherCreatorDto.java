package com.students.risky.dto.teacherdtos;

import com.students.risky.dto.schoolclassdtos.SchoolClassDto;
import com.students.risky.entity.SchoolClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherCreatorDto {
    private String firstName;
    private String lastName;
    private SchoolClass responsibleClass;
}
