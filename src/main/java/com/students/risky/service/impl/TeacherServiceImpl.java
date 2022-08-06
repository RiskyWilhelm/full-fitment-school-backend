package com.students.risky.service.impl;


import com.students.risky.dto.teacherdtos.TeacherCreatorDto;
import com.students.risky.dto.teacherdtos.TeacherDto;
import com.students.risky.entity.SchoolClass;
import com.students.risky.entity.Teacher;
import com.students.risky.repository.SchoolClassRepository;
import com.students.risky.repository.TeacherRepository;
import com.students.risky.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final SchoolClassRepository schoolClassRepository;

    private final ModelMapper modelMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, SchoolClassRepository schoolClassRepository, ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TeacherDto addTeacher(TeacherCreatorDto teacherDto) {
        if (teacherDto.getResponsibleClass() != null && schoolClassRepository.findById(teacherDto.getResponsibleClass().getId()).isEmpty()) {
            throw new RuntimeException("Cant find class");
        }
        else if (teacherDto.getResponsibleClass() == null)
        {
            Teacher createdTeacher = modelMapper.map(teacherDto, Teacher.class);
            return modelMapper.map(teacherRepository.save(createdTeacher), TeacherDto.class);
        }
        Optional<SchoolClass> foundClass = schoolClassRepository.findById(teacherDto.getResponsibleClass().getId());
        Teacher createdTeacher = modelMapper.map(teacherDto, Teacher.class);
        foundClass.get().setResponsibleTeacher(createdTeacher);
        return modelMapper.map(teacherRepository.save(createdTeacher), TeacherDto.class);
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> foundTeachers = teacherRepository.findAll();
        return foundTeachers.stream().map(teacher -> modelMapper.map(teacher, TeacherDto.class)).toList();
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        Optional<Teacher> foundTeacher = teacherRepository.findById(id);
        if (foundTeacher.isPresent()){
            return modelMapper.map(foundTeacher, TeacherDto.class);
        }
        throw new RuntimeException("Ogretmen bulunamadi");
    }

    @Override
    public TeacherDto deleteTeacherById(Long id) {
        Optional<Teacher> foundTeacher = teacherRepository.findById(id);
        if (foundTeacher.isPresent()){
//            Burası ogretmen silinirken ona bagli bir sinif varsa onu siler. Tabii cascade methodu kullansaydim boyle olmayacakti sonradan farkina vardim.
            if (foundTeacher.get().getResponsibleClass() != null && schoolClassRepository.findById(foundTeacher.get().getResponsibleClass().getId()).isPresent())
            {
                schoolClassRepository.findById(foundTeacher.get().getResponsibleClass().getId()).get().setResponsibleTeacher(null);
            }
            teacherRepository.deleteById(id);
            return modelMapper.map(foundTeacher, TeacherDto.class);
        }
        throw new RuntimeException("Ogretmen silinemedi; Sebep: Ogretmen bulunamadi veya bir sorun olustu. Kontrol edip tekrar deneyin. ");
    }

    @Override
    @Async
    public TeacherDto updateTeacherById(Long id, TeacherCreatorDto teacherCreatorDto) {
        Optional<Teacher> foundTeacher = teacherRepository.findById(id);
        if (foundTeacher.isPresent()){
            if (teacherCreatorDto.getFirstName() != null) foundTeacher.get().setFirstName(teacherCreatorDto.getFirstName());
            if (teacherCreatorDto.getLastName() != null) foundTeacher.get().setLastName(teacherCreatorDto.getLastName());
            if (teacherCreatorDto.getResponsibleClass() != null && schoolClassRepository.findById(teacherCreatorDto.getResponsibleClass().getId()).isEmpty())
                throw new RuntimeException("Sinif bulunamadi");
            if (teacherCreatorDto.getResponsibleClass() != null)
                schoolClassRepository.findById(teacherCreatorDto.getResponsibleClass().getId()).get().setResponsibleTeacher(foundTeacher.get());
            else if (foundTeacher.get().getResponsibleClass() != null)
                foundTeacher.get().getResponsibleClass().setResponsibleTeacher(null);

            return modelMapper.map(teacherRepository.save(foundTeacher.get()), TeacherDto.class);
        }
        throw new RuntimeException("Ogretmen bulunumadi. Girdiginiz verileri kontrol edin ve tekrar deneyin");
    }
}
