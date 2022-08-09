package com.students.risky.controller;

import com.students.risky.dto.schoolclassdtos.SchoolClassCreatorDto;
import com.students.risky.dto.schoolclassdtos.SchoolClassDto;
import com.students.risky.dto.studentdtos.StudentDto;
import com.students.risky.dto.schoolclassdtos.SchoolClassWithStudentListDto;
import com.students.risky.service.SchoolClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
@CrossOrigin("http://localhost:8080")
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @PostMapping("/createClass")
    public ResponseEntity<SchoolClassDto> addClass(@RequestBody SchoolClassCreatorDto schoolClassDto){
        SchoolClassDto createdClass = schoolClassService.addClass(schoolClassDto);
        return ResponseEntity.ok(createdClass);
    }

    @GetMapping("/getAllClasses")
    public ResponseEntity<List<SchoolClassWithStudentListDto>> getAllClasses(){
        List<SchoolClassWithStudentListDto> foundClasses = schoolClassService.getAllClasses();
        return ResponseEntity.ok(foundClasses);
    }


    @GetMapping("/getStudentsByClass/{id}")
    public ResponseEntity<List<StudentDto>> getAllStudentsByClassId(@PathVariable Long id){
        List<StudentDto> foundStudentsByClass = schoolClassService.getAllStudentsByClassId(id);
        return ResponseEntity.ok(foundStudentsByClass);
    }

    @GetMapping("/getStudentByClass/{classid}/{studentid}")
    public ResponseEntity<StudentDto> getStudentByClassId(@PathVariable Long classid, @PathVariable Long studentid){
        StudentDto foundStudentsByClass = schoolClassService.getStudentByClassId(classid, studentid);
        return ResponseEntity.ok(foundStudentsByClass);
    }

    @GetMapping("/getClass/{id}")
    public ResponseEntity<SchoolClassWithStudentListDto> getClassById(@PathVariable Long id){
        SchoolClassWithStudentListDto foundClass = schoolClassService.getClassById(id);
        return ResponseEntity.ok(foundClass);
    }

    @DeleteMapping("/deleteClass/{id}")
    public ResponseEntity<SchoolClassWithStudentListDto> deleteClassById(@PathVariable Long id){
        SchoolClassWithStudentListDto deletedClass = schoolClassService.deleteClassById(id);
        return ResponseEntity.ok(deletedClass);
    }

    @PutMapping("/updateClass/{id}")
    public ResponseEntity<SchoolClassWithStudentListDto> updateClassById(@PathVariable Long id, @RequestBody SchoolClassCreatorDto schoolClassCreatorDto){
        SchoolClassWithStudentListDto updatedClass = schoolClassService.updateClassById(id, schoolClassCreatorDto);
        return ResponseEntity.ok(updatedClass);
    }
}
