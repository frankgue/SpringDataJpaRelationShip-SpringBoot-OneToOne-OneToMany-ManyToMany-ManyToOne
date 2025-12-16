package com.gkfcsolution.springdatajparelationship.dto.requestDto;

import com.gkfcsolution.springdatajparelationship.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created on 2025 at 12:59
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 12:59
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestDto {
    private String name;
}
