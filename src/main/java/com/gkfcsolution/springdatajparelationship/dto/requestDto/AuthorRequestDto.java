package com.gkfcsolution.springdatajparelationship.dto.requestDto;

import com.gkfcsolution.springdatajparelationship.entity.Book;
import com.gkfcsolution.springdatajparelationship.entity.Zipcode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2025 at 12:58
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 12:58
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {
    private String name;

    private Long zipcodeId;

}
