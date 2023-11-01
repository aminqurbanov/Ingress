package com.example.bookstore.service.service;

import com.example.bookstore.dto.Request.AuthorRequest;
import com.example.bookstore.dto.Response.AuthorResponse;

import java.util.List;

public interface AuthorService {

    AuthorResponse save(AuthorRequest authorRequest);

    AuthorResponse updateAuthor(Long id, AuthorRequest authorRequest);

    List<AuthorResponse> findAll();

    AuthorResponse findById(Long id);

    void delete(Long id);
}

