package com.students.risky.service;

import com.students.risky.dto.teacherdtos.TeacherCreatorDto;
import com.students.risky.dto.teacherdtos.TeacherDto;

import java.util.List;

public interface TeacherService {
    TeacherDto addTeacher(TeacherCreatorDto teacherDto);

    List<TeacherDto> getAllTeachers();

    TeacherDto getTeacherById(Long id);

    TeacherDto deleteTeacherById(Long id);

    TeacherDto updateTeacherById(Long id, TeacherCreatorDto teacherCreatorDto);
}
