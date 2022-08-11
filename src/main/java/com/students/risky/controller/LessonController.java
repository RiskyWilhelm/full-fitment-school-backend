package com.students.risky.controller;

import com.students.risky.dto.coursedtos.LessonCreatorDto;
import com.students.risky.dto.coursedtos.LessonDto;
import com.students.risky.dto.coursedtos.LessonDtoWithStudentList;
import com.students.risky.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
//@CrossOrigin("http://localhost:8080")
@CrossOrigin("https://riskywilhelm.github.io/full-fitment-school-frontend/")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping("/createLesson")
    public ResponseEntity<LessonCreatorDto> addLesson(@RequestBody LessonCreatorDto lessonCreatorDto){
        LessonCreatorDto createdLesson = lessonService.addLesson(lessonCreatorDto);
        return ResponseEntity.ok(createdLesson);
    }

    @GetMapping("/getAllLessons")
    public ResponseEntity<List<LessonDtoWithStudentList>> getAllLessons(){
        List<LessonDtoWithStudentList> foundLessons = lessonService.getAllLessons();
        return ResponseEntity.ok(foundLessons);
    }

    @GetMapping("/getLessonById/{id}")
    public ResponseEntity<LessonDto> getLessonById(@PathVariable Long id){
        LessonDto foundLesson = lessonService.getLessonById(id);
        return ResponseEntity.ok(foundLesson);
    }

    @PutMapping("/updateLesson/{id}")
    public ResponseEntity<LessonDto> updateLessonById(@PathVariable Long id, @RequestBody LessonCreatorDto lessonCreatorDto){
        LessonDto updatedLesson = lessonService.updateLessonById(id, lessonCreatorDto);
        return ResponseEntity.ok(updatedLesson);
    }

    @DeleteMapping("/deleteLesson/{id}")
    public ResponseEntity<LessonDto> deleteLessonById(@PathVariable Long id){
        LessonDto deletedLesson = lessonService.deleteLessonById(id);
        return ResponseEntity.ok(deletedLesson);
    }
}
