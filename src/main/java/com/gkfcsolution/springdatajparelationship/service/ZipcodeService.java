package com.gkfcsolution.springdatajparelationship.service;

import com.gkfcsolution.springdatajparelationship.dto.requestDto.ZipcodeRequestDto;
import com.gkfcsolution.springdatajparelationship.entity.Zipcode;

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
public interface ZipcodeService {
    Zipcode addZipcode(ZipcodeRequestDto zipcodeRequestDto);
    List<Zipcode> getZipcodes();
    Zipcode getZipcode(Long zipcodeId);
    Zipcode deleteZipcode(Long zipcodeId);
    Zipcode editZipcode(Long zipcodeId, ZipcodeRequestDto zipcodeRequestDto);
    Zipcode addCityToZipcode(Long zipcodeId, Long cityId);
    Zipcode removeCityFromZipcode(Long zipcodeId, Long cityId);
}
