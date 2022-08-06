package com.students.risky.service.impl;

import com.students.risky.dto.coursedtos.LessonCreatorDto;
import com.students.risky.dto.coursedtos.LessonDto;
import com.students.risky.dto.coursedtos.LessonDtoWithStudentList;
import com.students.risky.entity.Lesson;
import com.students.risky.repository.LessonRepository;
import com.students.risky.service.LessonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    private final ModelMapper modelMapper;

    public LessonServiceImpl(LessonRepository lessonRepository, ModelMapper modelMapper) {
        this.lessonRepository = lessonRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LessonCreatorDto addLesson(LessonCreatorDto lessonCreatorDto) {
        Lesson createdLesson = modelMapper.map(lessonCreatorDto, Lesson.class);
        return modelMapper.map(lessonRepository.save(createdLesson), LessonCreatorDto.class);
    }

    @Override
    public List<LessonDtoWithStudentList> getAllLessons() {
        List<Lesson> foundLessons = lessonRepository.findAll();
        return foundLessons.stream().map(lesson -> modelMapper.map(lesson, LessonDtoWithStudentList.class)).toList();
    }

    @Override
    public LessonDto getLessonById(Long id) {
        Optional<Lesson> foundLesson = lessonRepository.findById(id);
        if (foundLesson.isPresent()){
            return modelMapper.map(foundLesson, LessonDto.class);
        }
        throw new RuntimeException("Ders bulunamadi");
    }

    @Override
    public LessonDto updateLessonById(Long id, LessonCreatorDto lessonCreatorDto) {
        Optional<Lesson> foundLesson = lessonRepository.findById(id);
        if (foundLesson.isPresent()){
            if (lessonCreatorDto.getLessonName() != null)
                foundLesson.get().setLessonName(lessonCreatorDto.getLessonName());
            else throw new RuntimeException("Lutfen ders ismini giriniz");

            return modelMapper.map(lessonRepository.save(foundLesson.get()), LessonDto.class);
        }
        throw new RuntimeException("Ders bulunamadi");
    }

    @Override
    public LessonDto deleteLessonById(Long id) {
        Optional<Lesson> foundLesson = lessonRepository.findById(id);
        if (foundLesson.isPresent()){
            lessonRepository.deleteById(id);
            return modelMapper.map(foundLesson, LessonDto.class);
        }
        throw new RuntimeException("Ders bulunamadi");
    }
}
