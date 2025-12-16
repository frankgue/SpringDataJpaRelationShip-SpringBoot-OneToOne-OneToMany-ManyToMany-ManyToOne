package com.gkfcsolution.springdatajparelationship.service;

import com.gkfcsolution.springdatajparelationship.dto.requestDto.AuthorRequestDto;
import com.gkfcsolution.springdatajparelationship.dto.requestDto.BookRequestDto;
import com.gkfcsolution.springdatajparelationship.dto.responseDto.AuthorResponseDto;
import com.gkfcsolution.springdatajparelationship.dto.responseDto.BookResponseDto;
import com.gkfcsolution.springdatajparelationship.entity.Author;
import com.gkfcsolution.springdatajparelationship.entity.Book;

import java.util.List;

/**
 * Created on 2025 at 13:56
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 13:56
 */
public interface BookService {
    BookResponseDto addBook(BookRequestDto bookRequestDto);
    BookResponseDto getBookById(Long bookId);
    Book getBook(Long bookId);
    List<BookResponseDto> getBooks();
    BookResponseDto deleteBook(Long bookId);
    BookResponseDto editBook(Long bookId, BookRequestDto bookRequestDto);
    BookResponseDto addAuthorToBook(Long bookId, Long authorId);
    BookResponseDto removeAuthorFomBook(Long bookId, Long authorId);
    BookResponseDto addCategoryToBook(Long bookId, Long categoryId);
    BookResponseDto removeCategoryFomBook(Long bookId, Long categoryId);
}
