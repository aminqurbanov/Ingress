package com.example.bookstore.service.impl;

import com.example.bookstore.domain.Author;
import com.example.bookstore.dto.Request.AuthorRequest;
import com.example.bookstore.dto.Response.AuthorResponse;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.service.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final ModelMapper modelMapper;
    private final AuthorRepository authorRepository;




    public List<AuthorResponse> findAll() {
        List<AuthorResponse> authorResponses = authorRepository
                .findAll()
                .stream()
                .map(author -> modelMapper.map(author, AuthorResponse.class))
                .collect(Collectors.toList());
        return authorResponses;


    }

    public AuthorResponse findById(Long id) {
       Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Author not found by id -%s", id)
        ));
        AuthorResponse authorResponse = modelMapper.map(author, AuthorResponse.class);
        return authorResponse;
    }

    @Override
    public AuthorResponse save(AuthorRequest authorRequest) {
        Author author = modelMapper.map(authorRequest, Author.class);
        Author save = authorRepository.save(author);
        return modelMapper.map(save, AuthorResponse.class);
    }
    @Override
    public AuthorResponse updateAuthor(Long id, AuthorRequest authorRequest) {
        authorRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Author not found for updating by id -%s", id)));
        Author responseAuthor = modelMapper.map(authorRequest, Author.class);
        responseAuthor.setId(id);
        return modelMapper.map(authorRepository.save(responseAuthor), AuthorResponse.class);
    }

    @Override
    public void delete(Long id) {
        authorRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Author not found by id -%s", id)
        ));

    }


}
