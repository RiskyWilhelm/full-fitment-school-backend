package com.students.risky.dto.studentdtos;

import com.students.risky.dto.BaseEntityNicknames;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCreatorDto extends BaseEntityNicknames {
    /*private String firstName;
    private String lastName;*/
//    BU SORUNSUZ CALISIYOR
//    private SchoolClass currentClass;
    private Long currentClass;
}
