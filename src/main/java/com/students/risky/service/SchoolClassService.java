package com.students.risky.service;

import com.students.risky.dto.schoolclassdtos.SchoolClassCreatorDto;
import com.students.risky.dto.schoolclassdtos.SchoolClassDto;
import com.students.risky.dto.studentdtos.StudentDto;
import com.students.risky.dto.schoolclassdtos.SchoolClassWithStudentListDto;

import java.util.List;

public interface SchoolClassService {
    List<StudentDto> getAllStudentsByClassId(Long id);

    StudentDto getStudentByClassId(Long classid, Long studentid);

    SchoolClassWithStudentListDto getClassById(Long id);

    SchoolClassDto addClass(SchoolClassCreatorDto schoolClassDto);

    List<SchoolClassWithStudentListDto> getAllClasses();

    SchoolClassWithStudentListDto deleteClassById(Long id);

    SchoolClassWithStudentListDto updateClassById(Long id, SchoolClassCreatorDto schoolClassCreatorDto);
}
