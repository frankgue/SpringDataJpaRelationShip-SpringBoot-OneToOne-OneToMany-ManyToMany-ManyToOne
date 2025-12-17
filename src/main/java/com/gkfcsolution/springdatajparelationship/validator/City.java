package com.gkfcsolution.springdatajparelationship.validator;

import com.gkfcsolution.springdatajparelationship.validator.CityValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * Created on 2025 at 13:35
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 17/12/2025
 * @time 13:35
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CityValidator.class)
@Documented
public @interface City {
    String message() default "Invalid city name";
    Class<?>[] groups() default {};
    Class<? extends jakarta.validation.Payload>[] payload() default {};
}
