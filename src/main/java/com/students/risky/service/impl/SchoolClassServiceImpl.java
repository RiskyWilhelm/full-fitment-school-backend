package com.students.risky.service.impl;

import com.students.risky.dto.schoolclassdtos.SchoolClassCreatorDto;
import com.students.risky.dto.schoolclassdtos.SchoolClassDto;
import com.students.risky.dto.studentdtos.StudentDto;
import com.students.risky.dto.schoolclassdtos.SchoolClassWithStudentListDto;
import com.students.risky.entity.SchoolClass;
import com.students.risky.entity.Student;
import com.students.risky.entity.Teacher;
import com.students.risky.repository.SchoolClassRepository;
import com.students.risky.repository.StudentRepository;
import com.students.risky.repository.TeacherRepository;
import com.students.risky.service.SchoolClassService;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolClassServiceImpl implements SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    private final ModelMapper modelMapper;

    public SchoolClassServiceImpl(SchoolClassRepository schoolClassRepository, StudentRepository studentRepository, TeacherRepository teacherRepository, ModelMapper modelMapper) {
        this.schoolClassRepository = schoolClassRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDto> getAllStudentsByClassId(Long id) {
        Optional<SchoolClass> foundClass = schoolClassRepository.findById(id);
        if (foundClass.isPresent()){
            List<Student> foundStudents = foundClass.get().getStudentList();
            if (!foundStudents.isEmpty()){
//                Ogrenciyi alirken icindeki sinifida aliyoruz. Ama ogrencinin sinifini alirken siniftaki ogrencilerin bir listesinide alıyoruz ki bu bize sonsuz bir dongu yaratıyor.
//                Sonuc olarak uygulama hata veriyor. Bu sebeple once aldıgımız ogrencinin sınıfındaki listesini dto yardimiyla kaldirdim.
//                Sonrasinda student nesnesini dtoya cevirdim.
                /*List<StudentDto> foundStudentsDto = foundStudents.stream().map(studentDto -> modelMapper.map(studentDto.getCurrentClass(), SchoolClassDto.class)).toList()
                        .stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();*/
                return foundStudents.stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();
            }
            throw new RuntimeException("Listede Ogrenci yok.");
        }
        throw new RuntimeException("Sinif bulunamadi");
    }

    @Override
    public StudentDto getStudentByClassId(Long classid, Long studentid) {
        Optional<SchoolClass> foundClass = schoolClassRepository.findById(classid);
        if (foundClass.isPresent()){
            List<Student> foundStudents = foundClass.get().getStudentList();
            Optional<Student> foundStudent = studentRepository.findById(studentid);
            if (foundStudents.isEmpty()){
                throw new RuntimeException("Listede ogrenci yok");
            }
            else if(foundStudent.isPresent() && foundStudents.contains(foundStudent.get())){
                return modelMapper.map(foundStudent, StudentDto.class);
            }
            else if(foundStudent.isPresent()){
                throw new RuntimeException("Ogrenci '" + foundStudent.get().getCurrentClass().getClassName() + "' Sınıfında.");
            }
            throw new RuntimeException("Ogrenci bulunamadi");
        }
        throw new RuntimeException("Sinif bulunamadi");
    }

    @Override
    public SchoolClassWithStudentListDto getClassById(Long id) {
        Optional<SchoolClass> foundClass = schoolClassRepository.findById(id);
        if (foundClass.isPresent()){
            return modelMapper.map(foundClass.get(), SchoolClassWithStudentListDto.class);
        }
        throw new RuntimeException("Sinif bulunamadi");
    }

    @Override
    public SchoolClassDto addClass(SchoolClassCreatorDto schoolClassDto) {
        if (schoolClassDto.getResponsibleTeacher() != null && teacherRepository.findById(schoolClassDto.getResponsibleTeacher().getId()).isEmpty())
            throw new RuntimeException("Teacher not found!");

        SchoolClass createdClass = modelMapper.map(schoolClassDto, SchoolClass.class);
        return modelMapper.map(schoolClassRepository.save(createdClass), SchoolClassDto.class);
    }

    @Override
    public List<SchoolClassWithStudentListDto> getAllClasses() {
        List<SchoolClass> foundClasses = schoolClassRepository.findAll();
        return foundClasses.stream().map(schoolClass -> modelMapper.map(schoolClass, SchoolClassWithStudentListDto.class)).toList();
    }

    @Override
    @Async
    public SchoolClassWithStudentListDto deleteClassById(Long id) {
        Optional<SchoolClass> foundClass = schoolClassRepository.findById(id);
        if (foundClass.isPresent()){
            foundClass.get().getStudentList().forEach(student -> student.setCurrentClass(null));

            if (foundClass.get().getResponsibleTeacher() != null && teacherRepository.findById(foundClass.get().getResponsibleTeacher().getId()).isPresent())
                foundClass.get().getResponsibleTeacher().setResponsibleClass(null);

            schoolClassRepository.deleteById(id);
            return modelMapper.map(foundClass, SchoolClassWithStudentListDto.class);
        }
        throw new RuntimeException("Sinif bulunamadi");
    }

    @Override
    public SchoolClassWithStudentListDto updateClassById(Long id, SchoolClassCreatorDto schoolClassCreatorDto) {
        Optional<SchoolClass> foundClass = schoolClassRepository.findById(id);
        if (foundClass.isPresent()){
            if (schoolClassCreatorDto.getClassName() != null) foundClass.get().setClassName(schoolClassCreatorDto.getClassName());
            if (schoolClassCreatorDto.getResponsibleTeacher() != null && teacherRepository.findById(schoolClassCreatorDto.getResponsibleTeacher().getId()).isEmpty())
                throw new RuntimeException("Ogretmen bulunamadi. Guncelleme iptal edildi.");

            if (schoolClassCreatorDto.getResponsibleTeacher() != null)
                foundClass.get().setResponsibleTeacher(modelMapper.map(schoolClassCreatorDto.getResponsibleTeacher(), Teacher.class));

            return modelMapper.map(schoolClassRepository.save(foundClass.get()), SchoolClassWithStudentListDto.class);
        }
        throw new RuntimeException("Sinif bulunamadi");
    }
}
