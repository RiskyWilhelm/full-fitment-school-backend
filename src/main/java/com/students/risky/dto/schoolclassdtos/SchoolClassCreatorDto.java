package com.students.risky.dto.schoolclassdtos;

import com.students.risky.entity.Teacher;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolClassCreatorDto {
//    This is for adding new class with teacher inside it. Others for reading data.
    private String className;
    private byte studentCount;
    private Teacher responsibleTeacher;
}
