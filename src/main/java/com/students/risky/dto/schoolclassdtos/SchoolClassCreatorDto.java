package com.students.risky.dto.schoolclassdtos;

import com.students.risky.entity.Teacher;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolClassCreatorDto {
//    Burasi bir sinif olusturacagimiz zaman kullanacagimiz dto nesnesi
    private String className;
//    private byte studentCount;
    private Long responsibleTeacher;
//    SORUNSUZ CALISIYOR
//    private Teacher responsibleTeacher;
}
