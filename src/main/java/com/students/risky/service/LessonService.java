package com.students.risky.service;


import com.students.risky.dto.coursedtos.LessonCreatorDto;
import com.students.risky.dto.coursedtos.LessonDto;
import com.students.risky.dto.coursedtos.LessonDtoWithStudentList;

import java.util.List;

public interface LessonService{
    LessonCreatorDto addLesson(LessonCreatorDto lessonCreatorDto);

    List<LessonDtoWithStudentList> getAllLessons();

    LessonDto getLessonById(Long id);

    LessonDto updateLessonById(Long id, LessonCreatorDto lessonCreatorDto);

    LessonDto deleteLessonById(Long id);
}
