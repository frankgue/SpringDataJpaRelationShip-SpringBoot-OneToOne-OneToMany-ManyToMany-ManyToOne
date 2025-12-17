package com.gkfcsolution.springdatajparelationship.controller;

import com.gkfcsolution.springdatajparelationship.dto.requestDto.CategoryRequestDto;
import com.gkfcsolution.springdatajparelationship.dto.responseDto.CategoryResponseDto;
import com.gkfcsolution.springdatajparelationship.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2025 at 11:27
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 17/12/2025
 * @time 11:27
 */
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        CategoryResponseDto categoryResponseDto = categoryService.addCategory(categoryRequestDto);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable Long id){
        CategoryResponseDto categoryResponseDto = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryResponseDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponseDto>> getCategories(){
        List<CategoryResponseDto> categoryResponseDtos = categoryService.getCategories();
        return ResponseEntity.ok(categoryResponseDtos);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryResponseDto> deleteCategory(@PathVariable Long id){
        CategoryResponseDto categoryResponseDto = categoryService.deleteCategory(id);
        return ResponseEntity.ok(categoryResponseDto);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<CategoryResponseDto> editCategory(@PathVariable Long id, @RequestBody CategoryRequestDto categoryRequestDto){
        CategoryResponseDto categoryResponseDto = categoryService.editCategory(id, categoryRequestDto);
        return ResponseEntity.ok(categoryResponseDto);

    }



}
