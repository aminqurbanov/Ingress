package com.example.bookstore.repository;

import com.example.bookstore.domain.Author;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}