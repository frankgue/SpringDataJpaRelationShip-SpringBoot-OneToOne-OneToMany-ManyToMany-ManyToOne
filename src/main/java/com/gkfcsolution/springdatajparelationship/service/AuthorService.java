package com.gkfcsolution.springdatajparelationship.service;

import com.gkfcsolution.springdatajparelationship.dto.requestDto.AuthorRequestDto;
import com.gkfcsolution.springdatajparelationship.dto.responseDto.AuthorResponseDto;
import com.gkfcsolution.springdatajparelationship.entity.Author;

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
public interface AuthorService {
    AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);
    List<AuthorResponseDto> getAuthors();
    AuthorResponseDto getAuthorById(Long authorId);
    Author getAuthor(Long authorId);
    AuthorResponseDto deleteAuthor(Long authorId);
    AuthorResponseDto editAuthor(Long authorId, AuthorRequestDto authorRequestDto);
    AuthorResponseDto addZipcodeToAuthor(Long authorId, Long zipcodeId);
    AuthorResponseDto removeZipcodeFromAuthor(Long authorId, Long zipcodeId);
}
