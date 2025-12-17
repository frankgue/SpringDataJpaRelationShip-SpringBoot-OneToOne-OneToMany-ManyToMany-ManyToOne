package com.gkfcsolution.springdatajparelationship.controller;

import com.gkfcsolution.springdatajparelationship.dto.requestDto.BookRequestDto;
import com.gkfcsolution.springdatajparelationship.dto.responseDto.BookResponseDto;
import com.gkfcsolution.springdatajparelationship.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2025 at 10:47
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 17/12/2025
 * @time 10:47
 */
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<BookResponseDto> addBook(@RequestBody final BookRequestDto bookRequestDto){
        BookResponseDto bookResponseDto = bookService.addBook(bookRequestDto);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable Long id){
        BookResponseDto bookResponseDto = bookService.getBookById(id);
        return ResponseEntity.ok(bookResponseDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BookResponseDto>> getBooks(){
        List<BookResponseDto> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookResponseDto> deleteBook(@PathVariable Long id){
        BookResponseDto deletedBook = bookService.deleteBook(id);
        return ResponseEntity.ok(deletedBook);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<BookResponseDto> updateBook(@PathVariable Long id, @RequestBody BookRequestDto bookRequestDto){
        BookResponseDto updatedBook = bookService.editBook(id, bookRequestDto);
        return ResponseEntity.ok(updatedBook);
    }

    @PostMapping("/addAuthor/{authorId}/toBook/{bookId}")
    public ResponseEntity<BookResponseDto> addAuthorToBook(
            @PathVariable Long authorId,
            @PathVariable Long bookId){
        BookResponseDto bookResponseDto = bookService.addAuthorToBook(bookId, authorId);
        return ResponseEntity.ok(bookResponseDto);
    }

    @PostMapping("/removeAuthor/{authorId}/fromBook/{bookId}")
    public ResponseEntity<BookResponseDto> removeAuthorFromBook(
            @PathVariable Long authorId,
            @PathVariable Long bookId){
        BookResponseDto bookResponseDto = bookService.removeAuthorFomBook(bookId, authorId);
        return ResponseEntity.ok(bookResponseDto);
    }

    @PostMapping("/addCategory/{categoryId}/toBook/{bookId}")
    public ResponseEntity<BookResponseDto> addCategoryToBook(
            @PathVariable Long categoryId,
            @PathVariable Long bookId){
        BookResponseDto bookResponseDto = bookService.addCategoryToBook(bookId, categoryId);
        return ResponseEntity.ok(bookResponseDto);
    }

    @PostMapping("/removeCategory/{categoryId}/fromBook/{bookId}")
    public ResponseEntity<BookResponseDto> removeCategoryFromBook(
            @PathVariable Long categoryId,
            @PathVariable Long bookId){
        BookResponseDto bookResponseDto = bookService.removeCategoryFomBook(bookId, categoryId);
        return ResponseEntity.ok(bookResponseDto);
    }
}
