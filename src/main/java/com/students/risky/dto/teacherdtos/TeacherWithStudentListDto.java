package com.students.risky.dto.teacherdtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.students.risky.dto.schoolclassdtos.SchoolClassWithStudentListDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherWithStudentListDto {
    private String firstName;
    private String lastName;
    //    Jsonbackreference sonsuz aratma sorunu reference yardımıyla cozuyor. Onetoone gibi verilerde bu projede kullanilmali.
    @JsonBackReference
    private SchoolClassWithStudentListDto responsibleClass;
}
