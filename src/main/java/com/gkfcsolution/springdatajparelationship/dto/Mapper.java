package com.gkfcsolution.springdatajparelationship.dto;

import com.gkfcsolution.springdatajparelationship.dto.responseDto.AuthorResponseDto;
import com.gkfcsolution.springdatajparelationship.dto.responseDto.BookResponseDto;
import com.gkfcsolution.springdatajparelationship.dto.responseDto.CategoryResponseDto;
import com.gkfcsolution.springdatajparelationship.entity.Author;
import com.gkfcsolution.springdatajparelationship.entity.Book;
import com.gkfcsolution.springdatajparelationship.entity.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2025 at 13:28
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 13:28
 */
public class Mapper {
    public static BookResponseDto bookToBookResponseDto(Book book){
        BookResponseDto bookResponseDto = BookResponseDto.builder()
                .id(book.getId())
                .categoryName(book.getCategory().getName())
                .build();

        List<String> names = new ArrayList<>();
        List<Author> authors = book.getAuthors();
        for (Author author : authors) {
            names.add(author.getName());
        }
        bookResponseDto.setAuthorNames(names);
        return bookResponseDto;
    }

    public static List<BookResponseDto> booksToBookResponseDtos(List<Book> books){
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for (Book book : books) {
            bookResponseDtos.add(bookToBookResponseDto(book));
        }
        return bookResponseDtos;
    }

    public static AuthorResponseDto authorToAuthorResponseDto(Author author){
        AuthorResponseDto authorResponseDto = AuthorResponseDto.builder()
                .id(author.getId())
                .name(author.getName())
                .bookNames(new ArrayList<>())
                .build();
        List<String> names = new ArrayList<>();
        List<Book> books = author.getBooks();
        for (Book book : books) {
            names.add(book.getName());
        }
        authorResponseDto.setBookNames(names);
        return authorResponseDto;

    }

    public static List<AuthorResponseDto> authorsToAuthorResponseDtos(List<Author> authors){
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
        for (Author author : authors) {
            authorResponseDtos.add(authorToAuthorResponseDto(author));
        }
        return authorResponseDtos;
    }

    public static CategoryResponseDto categoryToCategoryResponseDto(Category category){
        CategoryResponseDto categoryResponseDto = CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .bookNames(new ArrayList<>())
                .build();

        List<String> bookNames = new ArrayList<>();
        List<Book> books = category.getBooks();
        for (Book book : books) {
            bookNames.add(book.getName());
        }
        categoryResponseDto.setBookNames(bookNames);
        return categoryResponseDto;
    }

    public static List<CategoryResponseDto> categoriesToCategoryResponseDtos(List<Category> categories){
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for (com.gkfcsolution.springdatajparelationship.entity.Category category : categories) {
            categoryResponseDtos.add(categoryToCategoryResponseDto(category));
        }
        return categoryResponseDtos;
    }
}
