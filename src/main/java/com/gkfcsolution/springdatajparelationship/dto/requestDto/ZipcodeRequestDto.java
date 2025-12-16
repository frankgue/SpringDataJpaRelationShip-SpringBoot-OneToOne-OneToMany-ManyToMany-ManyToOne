package com.gkfcsolution.springdatajparelationship.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2025 at 12:57
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 12:57
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZipcodeRequestDto {
    private String name;
    private Long cityId;
}
