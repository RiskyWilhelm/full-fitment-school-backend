package com.students.risky.dto.teacherdtos;

import com.fasterxml.jackson.annotation.*;
import com.students.risky.dto.BaseEntityNicknames;
import com.students.risky.dto.schoolclassdtos.SchoolClassDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDto extends BaseEntityNicknames {
//    Buraya ne eklersek o postmanda gozukecek.
//    Bu SCHOOLCLASSDTOS ile birlikte calisir. Degistirilebilir.
    /*private String firstName;
    private String lastName;*/
    //    JsonIgnoreProperties yardımıyla gereksiz yere sorun yaratan veriyi gostermiyoruz. boylelikle infinite restruction sorunu gitmis oluyor.
    @JsonIgnoreProperties("responsibleTeacher")
    private SchoolClassDto responsibleClass;

//    SORUNSUZ CALISIOR
//    private SchoolClass responsibleClass;
}
