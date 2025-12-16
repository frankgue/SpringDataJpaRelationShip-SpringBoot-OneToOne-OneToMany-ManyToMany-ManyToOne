package com.gkfcsolution.springdatajparelationship.service;

import com.gkfcsolution.springdatajparelationship.dto.requestDto.CategoryRequestDto;
import com.gkfcsolution.springdatajparelationship.dto.requestDto.CityRequestDto;
import com.gkfcsolution.springdatajparelationship.dto.responseDto.CategoryResponseDto;
import com.gkfcsolution.springdatajparelationship.entity.Category;
import com.gkfcsolution.springdatajparelationship.entity.City;

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
public interface CategoryService {
    Category getCategory(Long categoryId);
    CategoryResponseDto getCategoryById(Long categoryId);
    CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);
    List<CategoryResponseDto> getCategories();
    CategoryResponseDto deleteCategory(Long categoryId);
    CategoryResponseDto editCategory(Long categoryId, CategoryRequestDto categoryRequestDto);
}
