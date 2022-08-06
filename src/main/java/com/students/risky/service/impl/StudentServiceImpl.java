package com.students.risky.service.impl;

import com.students.risky.dto.coursedtos.LessonCreatorDto;
import com.students.risky.dto.studentdtos.StudentCreatorDto;
import com.students.risky.dto.studentdtos.StudentDto;
import com.students.risky.entity.Lesson;
import com.students.risky.entity.SchoolClass;
import com.students.risky.entity.Student;
import com.students.risky.repository.LessonRepository;
import com.students.risky.repository.SchoolClassRepository;
import com.students.risky.repository.StudentRepository;
import com.students.risky.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final SchoolClassRepository schoolClassRepository;

    private final LessonRepository lessonRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository, LessonRepository lessonRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.lessonRepository = lessonRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto addStudent(StudentCreatorDto student) {
        if (student.getCurrentClass() != null && schoolClassRepository.findById(student.getCurrentClass().getId()).isEmpty())
            throw new RuntimeException("Sinif bulunamadi");
        Student createdStudent = modelMapper.map(student, Student.class);
//        System.out.println(createdStudent.getId() + " " + createdStudent.getFirstName() + " " + createdStudent.getLastName() + " " + createdStudent.getCurrentClass());
        return modelMapper.map(studentRepository.save(createdStudent), StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> foundStudents = studentRepository.findAll();
        return foundStudents.stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Optional<Student> foundStudent = studentRepository.findById(id);
        if (foundStudent.isPresent()){
            return modelMapper.map(foundStudent.get(), StudentDto.class);
        }
        throw new RuntimeException("Student Not Found");
    }

    @Override
    public StudentDto deleteStudentById(Long id) {
        Optional<Student> foundStudent = studentRepository.findById(id);
        if (foundStudent.isPresent()){
            studentRepository.deleteById(id);
            return modelMapper.map(foundStudent.get(), StudentDto.class);
        }
        throw new RuntimeException("Student Not Found");
    }

    @Override
    public StudentDto updateStudentById(Long id, StudentCreatorDto student) {
        Optional<Student> foundStudent = studentRepository.findById(id);
        if(foundStudent.isPresent()){
            if (student.getFirstName() != null) foundStudent.get().setFirstName(student.getFirstName());
            if (student.getLastName() != null) foundStudent.get().setLastName(student.getLastName());
            if (student.getCurrentClass() != null && schoolClassRepository.findById(student.getCurrentClass().getId()).isEmpty())
                throw new RuntimeException("Sinif bulunamadi");
//            student dtodaki currentclass bir schoolclassDTO nesnesi oldugu icin bunu school class yapiyoruz. cunku asil istedigi bir schoolclass ve biz onda dto verdigimizde hata veriyor.
            if (student.getCurrentClass() != null) foundStudent.get().setCurrentClass(modelMapper.map(student.getCurrentClass(), SchoolClass.class));


            return modelMapper.map(studentRepository.save(foundStudent.get()), StudentDto.class);
        }
        throw new RuntimeException("Ogrenci bulunamadi. Girdiginiz verileri kontrol edin ve tekrar deneyin");
    }

    @Override
    public Lesson addLesson(Long studentid, Long lessonid) {
        Optional<Student> foundStudent = studentRepository.findById(studentid);
        Optional<Lesson> foundLesson = lessonRepository.findById(lessonid);
//        Optional<Lesson> foundLesson =
        if (foundStudent.isEmpty())
            throw new RuntimeException("Ogrenci bulunamadi");
        else if (foundLesson.isEmpty())
            throw new RuntimeException("Ders bulunamadi");

        if (foundStudent.get().getLessonList().contains(foundLesson.get()))
            throw new RuntimeException("Ogrenci dersi zaten alıyor");

        foundStudent.get().addLesson(foundLesson.get());

        return modelMapper.map(studentRepository.save(foundStudent.get()), Lesson.class);
    }
}
