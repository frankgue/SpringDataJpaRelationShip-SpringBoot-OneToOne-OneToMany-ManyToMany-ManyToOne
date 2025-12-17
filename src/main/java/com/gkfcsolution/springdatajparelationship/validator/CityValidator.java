package com.gkfcsolution.springdatajparelationship.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Created on 2025 at 13:37
 * File: CityValidator.java.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 17/12/2025
 * @time 13:37
 */
public class CityValidator implements ConstraintValidator<City, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value.length() > 2;
    }
}
