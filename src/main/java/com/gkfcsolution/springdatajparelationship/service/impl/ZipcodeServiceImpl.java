package com.gkfcsolution.springdatajparelationship.service.impl;

import com.gkfcsolution.springdatajparelationship.dto.requestDto.ZipcodeRequestDto;
import com.gkfcsolution.springdatajparelationship.entity.City;
import com.gkfcsolution.springdatajparelationship.entity.Zipcode;
import com.gkfcsolution.springdatajparelationship.repository.ZipcodeRepository;
import com.gkfcsolution.springdatajparelationship.service.CityService;
import com.gkfcsolution.springdatajparelationship.service.ZipcodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created on 2025 at 14:08
 * File: ZipcodeServiceImpl.java.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 16/12/2025
 * @time 14:08
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ZipcodeServiceImpl implements ZipcodeService {
    private final ZipcodeRepository zipcodeRepository;
    private final CityService cityService;

    @Transactional
    @Override
    public Zipcode addZipcode(ZipcodeRequestDto zipcodeRequestDto) {
        Zipcode zipcode = Zipcode.builder()
                .name(zipcodeRequestDto.getName())
                .build();

        if (zipcodeRequestDto.getCityId() == null){
            return zipcodeRepository.save(zipcode);
        }

        City city = cityService.getCity(zipcodeRequestDto.getCityId());
        zipcode.setCity(city);

        return zipcode;
//        return zipcodeRepository.save(zipcode);
    }

    @Override
    public List<Zipcode> getZipcodes() {
        return StreamSupport.stream(zipcodeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Zipcode getZipcode(Long zipcodeId) {
        return zipcodeRepository.findById(zipcodeId).orElseThrow(() -> new IllegalArgumentException("Zipcode not found with id: " + zipcodeId));
    }

    @Override
    public Zipcode deleteZipcode(Long zipcodeId) {
        Zipcode zipcode = getZipcode(zipcodeId);
        zipcodeRepository.delete(zipcode);
        return zipcode;
    }

    @Transactional
    @Override
    public Zipcode editZipcode(Long zipcodeId, ZipcodeRequestDto zipcodeRequestDto) {
        Zipcode zipcodeToEdit = getZipcode(zipcodeId);
        zipcodeToEdit.setName(zipcodeRequestDto.getName());
        if (zipcodeRequestDto.getCityId() == null){
            return zipcodeRepository.save(zipcodeToEdit);
        }
        City city = cityService.getCity(zipcodeRequestDto.getCityId());
        zipcodeToEdit.setCity(city);


        return zipcodeToEdit;
//        return zipcodeRepository.save(zipcodeToEdit);
    }

    @Transactional
    @Override
    public Zipcode addCityToZipcode(Long zipcodeId, Long cityId) {
        Zipcode zipcode = getZipcode(zipcodeId);
        City city = cityService.getCity(cityId);

        if (Objects.nonNull(zipcode.getCity())){
            log.error("Zipcode with id {} already has a city assigned", zipcodeId);
            throw new IllegalStateException("Zipcode with id " + zipcodeId + " already has a city assigned");
        }
        zipcode.setCity(city);


        return zipcode;
//        return zipcodeRepository.save(zipcode);
    }

    @Transactional
    @Override
    public Zipcode removeCityFromZipcode(Long zipcodeId, Long cityId) {
        Zipcode zipcode = getZipcode(zipcodeId);
        if (!Objects.nonNull(zipcode.getCity())){
            log.error("Zipcode with id {} has no city assigned", zipcodeId);
           throw new IllegalStateException("Zipcode with id " + zipcodeId + " has no city assigned");
        }
        zipcode.setCity(null);
        return zipcode;
//        return zipcodeRepository.save(zipcode);
    }
}
