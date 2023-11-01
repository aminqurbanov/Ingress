package com.example.bookstore.service.impl;

import com.example.bookstore.domain.Student;
import com.example.bookstore.dto.Request.StudentRequest;
import com.example.bookstore.dto.Response.StudentResponse;
import com.example.bookstore.repository.StudentRepository;
import com.example.bookstore.service.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;



    @Override
    public StudentResponse findById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Student not found by id - %s", id)
        ));
        return modelMapper.map(student, StudentResponse.class);
    }

    @Override
    public List<StudentResponse> findAll() {
        List<StudentResponse> studentResponses = studentRepository
                .findAll()
                .stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
        return studentResponses;
    }

    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        Student student = modelMapper.map(studentRequest, Student.class);
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentResponse.class);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        studentRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Student not found for updating by id - %s", id)));
        Student responseStudent = modelMapper.map(studentRequest, Student.class);
        responseStudent.setId(id);
        return modelMapper.map(studentRepository.save(responseStudent), StudentResponse.class);

    }

    @Override
    public void delete(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Student not found by id -%s", id)
        ));

    }
}
