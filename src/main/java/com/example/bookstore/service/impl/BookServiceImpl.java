package com.example.bookstore.service.impl;

import com.example.bookstore.domain.Book;
import com.example.bookstore.dto.Request.BookRequest;
import com.example.bookstore.dto.Response.BookResponse;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;


    @Override
    public BookResponse findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Book not found by id - %s", id)
        ));
        return modelMapper.map(book, BookResponse.class);
    }

    @Override
    public List<BookResponse> findAll() {
        List<BookResponse> bookResponses = bookRepository
                .findAll()
                .stream()
                .map(book -> modelMapper.map(book, BookResponse.class))
                .collect(Collectors.toList());
        return bookResponses;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
        Book book = modelMapper.map(bookRequest, Book.class);
        Book savedBook = bookRepository.save(book);
        return modelMapper.map(savedBook, BookResponse.class);
    }

    @Override
    public BookResponse updateBook(Long id, BookRequest bookRequest) {
        bookRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Book not found for updating by id - %s", id)));
       Book responseBook = modelMapper.map(bookRequest, Book.class);
       responseBook.setId(id);
       return modelMapper.map(bookRepository.save(responseBook), BookResponse.class);
    }

    @Override
    public void delete(Long id) {
        bookRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Book not found by id -%s", id)
        ));

    }
}
