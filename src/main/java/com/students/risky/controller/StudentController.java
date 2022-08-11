package com.students.risky.controller;

import com.students.risky.dto.coursedtos.LessonCreatorDto;
import com.students.risky.dto.coursedtos.LessonDto;
import com.students.risky.dto.studentdtos.StudentCreatorDto;
import com.students.risky.dto.studentdtos.StudentDto;
import com.students.risky.entity.Lesson;
import com.students.risky.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Api(value = "Öğrenci API Dökümantasyonu", description = "Öğrenci ekleme çıkarma ve güncelleme gibi işlemler")
@CrossOrigin("https://riskywilhelm.github.io")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/createStudent")
    @ApiOperation(value = "Öğrenci ekleme kısmı")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentCreatorDto student){
        StudentDto createdStudent = studentService.addStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @PutMapping("/getStudent/{studentid}/addLesson/{lessonid}")
    @ApiOperation(value = "Öğrenciye ders ekleme kısmı")
    public ResponseEntity<Lesson> addLesson(@PathVariable Long studentid, @PathVariable Long lessonid){
        Lesson addedLesson = studentService.addLesson(studentid, lessonid);
        return ResponseEntity.ok(addedLesson);
    }

    @PutMapping("/getStudent/{studentid}/removeLesson/{lessonid}")
    @ApiOperation(value = "Öğrencinin dersini silme kısmı")
    public ResponseEntity<LessonCreatorDto> removeLesson(@PathVariable Long studentid, @PathVariable Long lessonid){
        LessonCreatorDto removedLesson = studentService.removeLesson(studentid, lessonid);
        return ResponseEntity.ok(removedLesson);
    }

    /*@DeleteMapping("/getStudent/{studentid}/removeLesson/{lessonid}")
    public */

    @GetMapping("/getAllStudents")
    @ApiOperation(value = "Bütün öğrencileri listeleme kısmı")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> allStudents = studentService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/getStudent/{id}")
    @ApiOperation(value = "Öğrenciyi girilen ID'ye göre bulma kısmı")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        StudentDto foundStudent = studentService.getStudentById(id);
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("/deleteStudent/{id}")
    @ApiOperation(value = "Öğrenciyi girilen ID'ye göre silme kısmı")
    public ResponseEntity<StudentDto> deleteStudentById(@PathVariable Long id){
        StudentDto foundStudent = studentService.deleteStudentById(id);
        return ResponseEntity.ok(foundStudent);
    }

    @PutMapping("/updateStudent/{id}")
    @ApiOperation(value = "Öğrenciyi girilen ID'ye göre güncelleme kısmı", notes = "Not testi")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable Long id, @RequestBody StudentCreatorDto student){
        StudentDto updatedStudent = studentService.updateStudentById(id, student);
        return ResponseEntity.ok(updatedStudent);
    }
}
