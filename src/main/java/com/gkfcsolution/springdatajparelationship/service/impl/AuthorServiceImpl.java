package com.gkfcsolution.springdatajparelationship.service.impl;

import com.gkfcsolution.springdatajparelationship.dto.Mapper;
import com.gkfcsolution.springdatajparelationship.dto.requestDto.AuthorRequestDto;
import com.gkfcsolution.springdatajparelationship.dto.requestDto.CityRequestDto;
import com.gkfcsolution.springdatajparelationship.dto.responseDto.AuthorResponseDto;
import com.gkfcsolution.springdatajparelationship.entity.Author;
import com.gkfcsolution.springdatajparelationship.entity.Zipcode;
import com.gkfcsolution.springdatajparelationship.repository.AuthorRepository;
import com.gkfcsolution.springdatajparelationship.service.AuthorService;
import com.gkfcsolution.springdatajparelationship.service.ZipcodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 2025 at 14:28
 * File: AuthorServiceImpl.java.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 14:28
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final ZipcodeService zipcodeService;

    @Transactional
    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
        Author author = Author.builder()
                .name(authorRequestDto.getName())
                .build();

        if (authorRequestDto.getZipcodeId() == null) {
            log.error("Zipcode ID is required to add an author.");
            throw new IllegalArgumentException("Zipcode ID is required to add an author.");
        }

        Zipcode zipcode = zipcodeService.getZipcode(authorRequestDto.getZipcodeId());
        author.setZipcode(zipcode);
        authorRepository.save(author);

        return Mapper.authorToAuthorResponseDto(author);
    }

    @Override
    public List<AuthorResponseDto> getAuthors() {
        return null;
    }

    @Override
    public AuthorResponseDto getAuthorById(Long authorId) {
        return null;
    }

    @Override
    public Author getAuthor(Long authorId) {
        return null;
    }

    @Override
    public AuthorResponseDto deleteAuthor(Long authorId) {
        return null;
    }

    @Override
    public AuthorResponseDto editAuthor(Long authorId, AuthorRequestDto authorRequestDto) {
        return null;
    }

    @Override
    public AuthorResponseDto addZipcodeToAuthor(Long authorId, Long zipcodeId) {
        return null;
    }

    @Override
    public AuthorResponseDto removeZipcodeFromAuthor(Long authorId, Long zipcodeId) {
        return null;
    }
}
