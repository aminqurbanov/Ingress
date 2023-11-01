package com.example.bookstore.dto.Response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class BookResponse {
    Long id;

    String name;
}
