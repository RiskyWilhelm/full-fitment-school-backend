package com.students.risky.dto.teacherdtos;

import com.students.risky.dto.BaseEntityNicknames;
import com.students.risky.dto.schoolclassdtos.SchoolClassDto;
import com.students.risky.entity.SchoolClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherCreatorDto extends BaseEntityNicknames {
    /*private String firstName;
    private String lastName;*/
    private Long responsibleClass;
//    SORUNSUZ CALISIYOR
//    private SchoolClass responsibleClass;
}
