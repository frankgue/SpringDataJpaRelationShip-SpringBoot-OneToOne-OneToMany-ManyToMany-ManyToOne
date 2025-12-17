package com.gkfcsolution.springdatajparelationship.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2025 at 11:20
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 11:20
 */
@Entity
@Table(name = "City")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @com.gkfcsolution.springdatajparelationship.validator.City
    @NotEmpty(message = "City name must not be empty")
    private String name;

    public City(String name) {
        this.name = name;
    }
}
