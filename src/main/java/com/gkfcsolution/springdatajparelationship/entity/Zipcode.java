package com.gkfcsolution.springdatajparelationship.entity;

import jakarta.persistence.*;
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
@Table(name = "Zipcode")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Zipcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public Zipcode(String name, City city) {
        this.name = name;
        this.city = city;
    }
}
