package com.gkfcsolution.springdatajparelationship.service.impl;

import com.gkfcsolution.springdatajparelationship.dto.requestDto.CityRequestDto;
import com.gkfcsolution.springdatajparelationship.entity.City;
import com.gkfcsolution.springdatajparelationship.repository.CityRepository;
import com.gkfcsolution.springdatajparelationship.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2025 at 13:59
 * File: CityServiceImpl.java.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 13:59
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    @Override
    public City addCity(CityRequestDto cityRequestDto) {
        City city = City.builder()
                .name(cityRequestDto.getName())
                .build();
        return cityRepository.save(city);
    }

    @Override
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(cities::add);
        return cities;
    }

    @Override
    public City getCity(Long cityId) {
        return cityRepository.findById(cityId).orElseThrow(() -> new IllegalArgumentException("City not found with id: " + cityId));
    }

    @Override
    public City deleteCity(Long cityId) {
        City city = getCity(cityId);
        cityRepository.delete(city);
        return city;
    }

    @Override
    public City editCity(Long cityId, CityRequestDto cityRequestDto) {
        City cityToEdit = getCity(cityId);
        cityToEdit.setName(cityRequestDto.getName());
        return cityRepository.save(cityToEdit);
    }
}
