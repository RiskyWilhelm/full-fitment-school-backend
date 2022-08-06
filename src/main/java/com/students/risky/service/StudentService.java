package com.students.risky.service;

import com.students.risky.dto.studentdtos.StudentCreatorDto;
import com.students.risky.dto.studentdtos.StudentDto;
import com.students.risky.entity.Lesson;

import java.util.List;

public interface StudentService {
    StudentDto addStudent(StudentCreatorDto student);

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto deleteStudentById(Long id);

    StudentDto updateStudentById(Long id, StudentCreatorDto student);

    Lesson addLesson(Long studentid, Long lessonid);
}
