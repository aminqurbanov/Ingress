package com.example.bookstore.service.service;

import com.example.bookstore.dto.Request.BookRequest;
import com.example.bookstore.dto.Response.BookResponse;
import java.util.List;

    public interface BookService {
        BookResponse findById(Long id);

        List<BookResponse> findAll();

        BookResponse save(BookRequest bookRequest);

        BookResponse updateBook(Long id, BookRequest bookRequest);

        void delete(Long id);
    }

