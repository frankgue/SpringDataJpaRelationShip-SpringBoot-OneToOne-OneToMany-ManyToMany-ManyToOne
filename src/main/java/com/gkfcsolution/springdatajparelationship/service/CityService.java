package com.gkfcsolution.springdatajparelationship.service;

import com.gkfcsolution.springdatajparelationship.dto.requestDto.CityRequestDto;
import com.gkfcsolution.springdatajparelationship.entity.City;

import java.util.List;

/**
 * Created on 2025 at 13:56
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 13:56
 */
public interface CityService {
    City addCity(CityRequestDto cityRequestDto);
    List<City> getCities();
    City getCity(Long cityId);
    City deleteCity(Long cityId);
    City editCity(Long cityId, CityRequestDto cityRequestDto);
}
