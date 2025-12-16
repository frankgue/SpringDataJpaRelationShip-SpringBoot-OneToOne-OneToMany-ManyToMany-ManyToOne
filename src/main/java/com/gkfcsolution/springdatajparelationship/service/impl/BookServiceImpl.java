package com.gkfcsolution.springdatajparelationship.service.impl;

import com.gkfcsolution.springdatajparelationship.dto.Mapper;
import com.gkfcsolution.springdatajparelationship.dto.requestDto.BookRequestDto;
import com.gkfcsolution.springdatajparelationship.dto.responseDto.BookResponseDto;
import com.gkfcsolution.springdatajparelationship.entity.Author;
import com.gkfcsolution.springdatajparelationship.entity.Book;
import com.gkfcsolution.springdatajparelationship.entity.Category;
import com.gkfcsolution.springdatajparelationship.repository.BookRepository;
import com.gkfcsolution.springdatajparelationship.service.AuthorService;
import com.gkfcsolution.springdatajparelationship.service.BookService;
import com.gkfcsolution.springdatajparelationship.service.CategoryService;
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
 * File: BookServiceImpl.java.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 14:28
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Transactional
    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        Book book = Book.builder()
                .name(bookRequestDto.getName())
                .build();

        if (bookRequestDto.getAuthorIds().isEmpty()) {
            log.error("A book must have at least one author");
            throw new IllegalArgumentException("A book must have at least one author");
        } else {
            List<Author> authors = new ArrayList<>();
            for (Long authorId : bookRequestDto.getAuthorIds()) {
                Author author = authorService.getAuthor(authorId);
                authors.add(author);
            }
            book.setAuthors(authors);
        }

        if (bookRequestDto.getCategoryId() == null) {
            log.error("A book must belong to at least one category");
            throw new IllegalArgumentException("A book must belong to at least one category");
        }
        Category category = categoryService.getCategory(bookRequestDto.getCategoryId());
        book.setCategory(category);

        Book savedBook = bookRepository.save(book);
        return Mapper.bookToBookResponseDto(savedBook);

    }

    @Override
    public BookResponseDto getBookById(Long bookId) {
        Book book = getBook(bookId);
        return Mapper.bookToBookResponseDto(book);
    }

    @Override
    public Book getBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + bookId));
        return book;
    }

    @Override
    public List<BookResponseDto> getBooks() {
        List<Book> books = StreamSupport
                .stream(bookRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return Mapper.booksToBookResponseDtos(books);
    }

    @Override
    public BookResponseDto deleteBook(Long bookId) {
        Book book = getBook(bookId);
        bookRepository.delete(book);
        return Mapper.bookToBookResponseDto(book);
    }

    @Transactional
    @Override
    public BookResponseDto editBook(Long bookId, BookRequestDto bookRequestDto) {
        Book bookToEdit = getBook(bookId);
        bookToEdit.setName(bookRequestDto.getName());
        if (bookRequestDto.getAuthorIds().isEmpty()) {
            log.error("A book must have at least one author");
            throw new IllegalArgumentException("A book must have at least one author");
        } else {
            List<Author> authors = new ArrayList<>();
            for (Long authorId : bookRequestDto.getAuthorIds()) {
                Author author = authorService.getAuthor(authorId);
                authors.add(author);
            }
            bookToEdit.setAuthors(authors);
        }

        if (bookRequestDto.getCategoryId() == null) {
            log.error("A book must belong to at least one category");
            throw new IllegalArgumentException("A book must belong to at least one category");
        }else {
            Category category = categoryService.getCategory(bookRequestDto.getCategoryId());
            bookToEdit.setCategory(category);
        }

        return Mapper.bookToBookResponseDto(bookToEdit);
//        return Mapper.bookToBookResponseDto(bookRepository.save(bookToEdit));
    }

    @Transactional
    @Override
    public BookResponseDto addAuthorToBook(Long bookId, Long authorId) {
        Book book = getBook(bookId);
        Author author = authorService.getAuthor(authorId);
        if (author.getBooks().contains(author)) {
            log.error("Author with id {} is already assigned to book with id {}", authorId, bookId);
            throw new IllegalStateException("Author with id " + authorId + " is already assigned to book with id " + bookId);
        }
        book.addAuthor(author);
        author.addBook(book);
        return Mapper.bookToBookResponseDto(book);
    }

    @Transactional

    @Override
    public BookResponseDto removeAuthorFomBook(Long bookId, Long authorId) {
        Book book = getBook(bookId);
        Author author = authorService.getAuthor(authorId);
        if (!author.getBooks().contains(book)) {
            log.error("Author with id {} is not assigned to book with id {}", authorId, bookId);
            throw new IllegalStateException("Author with id " + authorId + " is not assigned to book with id " + bookId);
        }
        book.removeAuthor(author);
        author.removeBook(book);
        return Mapper.bookToBookResponseDto(book);
    }


    @Transactional
    @Override
    public BookResponseDto addCategoryToBook(Long bookId, Long categoryId) {
        Book book = getBook(bookId);
        Category category = categoryService.getCategory(categoryId);
        if (Objects.nonNull(book.getCategory())) {
            log.error("Book with id {} already has a category assigned", bookId);
            throw new IllegalStateException("Book with id " + bookId + " already has a category assigned");
        }
        book.setCategory(category);
        category.addBook(book);
        return Mapper.bookToBookResponseDto(book);
    }


    @Transactional
    @Override
    public BookResponseDto removeCategoryFomBook(Long bookId, Long categoryId) {
        Book book = getBook(bookId);
        Category category = categoryService.getCategory(categoryId);
        if (!(Objects.nonNull(book.getCategory()))){
            log.error("Book with id {} has no category assigned", bookId);
            throw new IllegalStateException("Book with id " + bookId + " has no category assigned");
        }
        book.setCategory(null);
        category.removeBook(book);
        return Mapper.bookToBookResponseDto(book);
    }
}
