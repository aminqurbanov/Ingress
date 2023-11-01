package com.example.bookstore.service.service;

import com.example.bookstore.dto.Request.StudentRequest;
import com.example.bookstore.dto.Response.StudentResponse;
import java.util.List;

public interface StudentService {
    StudentResponse findById(Long id);

    List<StudentResponse> findAll();

    StudentResponse save(StudentRequest studentRequest);

    StudentResponse updateStudent(Long id, StudentRequest studentRequest);

    void delete(Long id);
}
