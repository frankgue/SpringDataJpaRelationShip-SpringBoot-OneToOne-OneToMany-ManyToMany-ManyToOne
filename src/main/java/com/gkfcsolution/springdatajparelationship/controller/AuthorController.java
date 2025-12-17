package com.gkfcsolution.springdatajparelationship.controller;

import com.gkfcsolution.springdatajparelationship.dto.requestDto.AuthorRequestDto;
import com.gkfcsolution.springdatajparelationship.dto.responseDto.AuthorResponseDto;
import com.gkfcsolution.springdatajparelationship.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2025 at 10:31
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 17/12/2025
 * @time 10:31
 */
@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
@Slf4j
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/addAuthor")
    public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody final AuthorRequestDto authorRequestDto) {
        AuthorResponseDto authorResponseDto = authorService.addAuthor(authorRequestDto);
        return ResponseEntity.ok(authorResponseDto);
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthorById(@RequestBody final Long id) {
        AuthorResponseDto authorResponseDto = authorService.getAuthorById(id);
        return ResponseEntity.ok(authorResponseDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthors() {
        List<AuthorResponseDto> authors = authorService.getAuthors();
        return ResponseEntity.ok(authors);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AuthorResponseDto> deleteAuthor(@PathVariable Long id) {
        AuthorResponseDto deletedAuthor = authorService.deleteAuthor(id);
        return ResponseEntity.ok(deletedAuthor);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<AuthorResponseDto> editAuthor(
            @PathVariable Long id,
            @RequestBody AuthorRequestDto authorRequestDto) {
        AuthorResponseDto updatedAuthor = authorService.editAuthor(id, authorRequestDto);
        return ResponseEntity.ok(updatedAuthor);
    }

    @PostMapping("/addZipcode/{zipcodeId}/toAuthor/{authorId}")
    public ResponseEntity<AuthorResponseDto> addZipcodeToAuthor(
            @PathVariable Long authorId,
            @PathVariable Long zipcodeId) {
        AuthorResponseDto updatedAuthor = authorService.addZipcodeToAuthor(authorId, zipcodeId);
        return ResponseEntity.ok(updatedAuthor);
    }

    @PostMapping("/removeZipcode/{zipcodeId}/fromAuthor/{authorId}")
    public ResponseEntity<AuthorResponseDto> removeZipcodeFromAuthor(
            @PathVariable Long authorId,
            @PathVariable Long zipcodeId) {
        AuthorResponseDto updatedAuthor = authorService.removeZipcodeFromAuthor(authorId, zipcodeId);
        return ResponseEntity.ok(updatedAuthor);
    }
}
