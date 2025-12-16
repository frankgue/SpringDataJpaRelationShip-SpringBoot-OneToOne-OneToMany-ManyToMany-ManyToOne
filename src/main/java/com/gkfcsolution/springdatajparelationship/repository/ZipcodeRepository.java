package com.gkfcsolution.springdatajparelationship.repository;

import com.gkfcsolution.springdatajparelationship.entity.Author;
import com.gkfcsolution.springdatajparelationship.entity.Zipcode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2025 at 13:50
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 13:50
 */
public interface ZipcodeRepository extends JpaRepository<Zipcode, Long> {
}
