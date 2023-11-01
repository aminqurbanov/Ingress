package com.example.bookstore.controller;

import com.example.bookstore.dto.Request.AuthorRequest;
import com.example.bookstore.dto.Response.AuthorResponse;
import com.example.bookstore.service.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/authors/v1")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(authorService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuthorResponse>> findAll() {
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> save(@RequestBody AuthorRequest authorRequest) {
        return new ResponseEntity<>(authorService.save(authorRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthor(@PathVariable Long id, @RequestBody AuthorRequest authorRequest) {
        return new ResponseEntity<>(authorService.updateAuthor(id, authorRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
}
