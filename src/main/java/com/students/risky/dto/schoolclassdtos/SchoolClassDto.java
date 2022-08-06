package com.students.risky.dto.schoolclassdtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.students.risky.dto.teacherdtos.TeacherDto;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class SchoolClassDto {
//    Buraya ne eklersek o postmanda gozukecek.
//    Bu teacherdto ile birlikte calisir.  Eger TEACHERDTO tipini degistirecek olursaniz mapping error 1]  verecektir. Yani veri tipi uyumsuzlugu hatasini verir.
    private String className;
    private byte studentCount;
    @JsonIgnoreProperties("responsibleClass")
    private TeacherDto responsibleTeacher;
}
