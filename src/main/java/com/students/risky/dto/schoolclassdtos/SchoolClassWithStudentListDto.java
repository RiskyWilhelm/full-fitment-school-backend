package com.students.risky.dto.schoolclassdtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.students.risky.dto.studentdtos.StudentDtoWithStudentListDto;
import com.students.risky.dto.teacherdtos.TeacherWithStudentListDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SchoolClassWithStudentListDto {
//    Buraya ne eklersek o postmanda gozukecek.
//    Bu teacherwithstudentlistdto ile birlikte calisir. Eger degistirecek olursaniz mapping error 1]  verecektir. Yani veri tipi uyumsuzlugu verir.
    private String className;
    private byte studentCount;
    @JsonIgnoreProperties("responsibleClass")
    private TeacherWithStudentListDto responsibleTeacher;
    private List<StudentDtoWithStudentListDto> studentList = new ArrayList<>();
}
