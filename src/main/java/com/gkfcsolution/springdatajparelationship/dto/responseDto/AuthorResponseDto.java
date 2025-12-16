package com.gkfcsolution.springdatajparelationship.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created on 2025 at 13:16
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 13:16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {
    private Long id;
    private String name;
    private List<String> bookNames;
    private String zipcodeName;
}
