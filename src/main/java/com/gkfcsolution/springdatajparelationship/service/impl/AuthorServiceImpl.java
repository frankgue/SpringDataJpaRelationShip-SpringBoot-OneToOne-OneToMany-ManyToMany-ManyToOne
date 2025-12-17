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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
                .books(new ArrayList<>())
                .build();

        if (authorRequestDto.getZipcodeId() == null) {
            log.error("Zipcode ID is required to add an author.");
            throw new IllegalArgumentException("Zipcode ID is required to add an author.");
        }

        Zipcode zipcode = zipcodeService.getZipcode(authorRequestDto.getZipcodeId());
        author.setZipcode(zipcode);
//        authorRepository.save(author);

        return Mapper.authorToAuthorResponseDto(authorRepository.save(author));
    }

    @Override
    public List<AuthorResponseDto> getAuthors() {
        List<Author> authors = StreamSupport.stream(authorRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return Mapper.authorsToAuthorResponseDtos(authors);
    }

    @Override
    public AuthorResponseDto getAuthorById(Long authorId) {
        return Mapper.authorToAuthorResponseDto(getAuthor(authorId));
    }

    @Override
    public Author getAuthor(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Author not found with id: " + authorId));
    }

    @Override
    public AuthorResponseDto deleteAuthor(Long authorId) {
        Author author = getAuthor(authorId);
        authorRepository.delete(author);
        return Mapper.authorToAuthorResponseDto(author);
    }

    @Transactional
    @Override
    public AuthorResponseDto editAuthor(Long authorId, AuthorRequestDto authorRequestDto) {
        Author authorToEdit = getAuthor(authorId);
        authorToEdit.setName(authorRequestDto.getName());
        if(authorRequestDto.getZipcodeId() != null){
            Zipcode zipcode = zipcodeService.getZipcode(authorRequestDto.getZipcodeId());
            authorToEdit.setZipcode(zipcode);
        }
        return Mapper.authorToAuthorResponseDto(authorRepository.save(authorToEdit));
    }

    @Transactional
    @Override
    public AuthorResponseDto addZipcodeToAuthor(Long authorId, Long zipcodeId) {
        Author author = getAuthor(authorId);
        Zipcode zipcode = zipcodeService.getZipcode(zipcodeId);
        if (Objects.nonNull(author.getZipcode())){
            log.error("Author with id {} already has a zipcode assigned", authorId);
            throw new IllegalStateException("Author with id " + authorId + " already has a zipcode assigned");
        }
        author.setZipcode(zipcode);
        return Mapper.authorToAuthorResponseDto(authorRepository.save(author));
    }

    @Transactional
    @Override
    public AuthorResponseDto removeZipcodeFromAuthor(Long authorId, Long zipcodeId) {
        Author author = getAuthor(authorId);
        author.setZipcode(null);
        return Mapper.authorToAuthorResponseDto(authorRepository.save(author));
    }
}
