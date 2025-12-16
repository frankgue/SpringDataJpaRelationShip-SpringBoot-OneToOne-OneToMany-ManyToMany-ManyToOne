package com.gkfcsolution.springdatajparelationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
@Table(name = "Category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books;

    public Category(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

}
