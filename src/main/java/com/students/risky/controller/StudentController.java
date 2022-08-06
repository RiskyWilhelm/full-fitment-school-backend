package com.students.risky.controller;

import com.students.risky.dto.coursedtos.LessonCreatorDto;
import com.students.risky.dto.studentdtos.StudentCreatorDto;
import com.students.risky.dto.studentdtos.StudentDto;
import com.students.risky.entity.Lesson;
import com.students.risky.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/createStudent")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentCreatorDto student){
        StudentDto createdStudent = studentService.addStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @PutMapping("/getStudent/{studentid}/addLesson/{lessonid}")
    public ResponseEntity<Lesson> addLesson(@PathVariable Long studentid, @PathVariable Long lessonid){
        Lesson addedLesson = studentService.addLesson(studentid, lessonid);
        return ResponseEntity.ok(addedLesson);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> allStudents = studentService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        StudentDto foundStudent = studentService.getStudentById(id);
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<StudentDto> deleteStudentById(@PathVariable Long id){
        StudentDto foundStudent = studentService.deleteStudentById(id);
        return ResponseEntity.ok(foundStudent);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable Long id, @RequestBody StudentCreatorDto student){
        StudentDto updatedStudent = studentService.updateStudentById(id, student);
        return ResponseEntity.ok(updatedStudent);
    }
}
