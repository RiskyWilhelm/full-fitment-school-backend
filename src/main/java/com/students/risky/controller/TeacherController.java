package com.students.risky.controller;

import com.students.risky.dto.teacherdtos.TeacherCreatorDto;
import com.students.risky.dto.teacherdtos.TeacherDto;
import com.students.risky.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@CrossOrigin("http://riskywilhelm.github.io/full-fitment-school-frontend/")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/createTeacher")
    public ResponseEntity<TeacherDto> addTeacher(@RequestBody TeacherCreatorDto teacherDto){
        TeacherDto createdTeacher = teacherService.addTeacher(teacherDto);
        return ResponseEntity.ok(createdTeacher);
    }

    @GetMapping("/getAllTeachers")
    public ResponseEntity<List<TeacherDto>> getAllTeachers(){
        List<TeacherDto> foundTeachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(foundTeachers);
    }

    @GetMapping("/getTeacher/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id){
        TeacherDto foundTeacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok(foundTeacher);
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public ResponseEntity<TeacherDto> deleteTeacherById(@PathVariable Long id){
        TeacherDto deletedTeacher = teacherService.deleteTeacherById(id);
        return ResponseEntity.ok(deletedTeacher);
    }

    @PutMapping("/updateTeacher/{id}")
    public ResponseEntity<TeacherDto> updateTeacherById(@PathVariable Long id, @RequestBody TeacherCreatorDto teacherCreatorDto){
        TeacherDto updatedTeacher = teacherService.updateTeacherById(id, teacherCreatorDto);
        return ResponseEntity.ok(updatedTeacher);
    }

}
