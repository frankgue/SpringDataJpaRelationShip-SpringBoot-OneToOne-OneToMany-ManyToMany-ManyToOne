package com.gkfcsolution.springdatajparelationship.controller;

import com.gkfcsolution.springdatajparelationship.dto.requestDto.ZipcodeRequestDto;
import com.gkfcsolution.springdatajparelationship.entity.Zipcode;
import com.gkfcsolution.springdatajparelationship.service.ZipcodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2025 at 10:12
 * File: null.java
 * Project: SpringDataJpaRelationShip
 *
 * @author Frank GUEKENG
 * @date 17/12/2025
 * @time 10:12
 */
@RestController
@RequestMapping("/api/zipcodes")
@RequiredArgsConstructor
@Slf4j
public class ZipcodeController {
    private final ZipcodeService zipcodeService;

    @PostMapping("/add")
    public ResponseEntity<Zipcode> addZipcode(@RequestBody final ZipcodeRequestDto zipcodeRequestDto){
        Zipcode zipcode = zipcodeService.addZipcode(zipcodeRequestDto);
        return ResponseEntity.status(201).body(zipcode);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Zipcode> getCity(@PathVariable Long id){
        Zipcode zipcode = zipcodeService.getZipcode(id);
        return ResponseEntity.ok(zipcode);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Zipcode>> getAllZipcodes(){
        List<Zipcode> zipcodes = zipcodeService.getZipcodes();
        return ResponseEntity.ok(zipcodes);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Zipcode> deleteZipcode(@PathVariable Long id){
        Zipcode zipcode = zipcodeService.deleteZipcode(id);
        return ResponseEntity.ok(zipcode);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Zipcode> editZipcode(@RequestBody final ZipcodeRequestDto zipcodeRequestDto, @PathVariable Long id){
        Zipcode zipcode = zipcodeService.editZipcode(id, zipcodeRequestDto);
        return ResponseEntity.ok(zipcode);
    }

    @PostMapping("/addCity/{cityId}/toZipcode/{zipcodeId}")
    public ResponseEntity<Zipcode> addCity(@PathVariable Long cityId, @PathVariable Long zipcodeId){
        Zipcode zipcode = zipcodeService.addCityToZipcode(zipcodeId, cityId);
        return ResponseEntity.ok(zipcode);
    }

    @PostMapping("/removeCity/{cityId}/fromZipcode/{zipcodeId}")
    public ResponseEntity<Zipcode> removeCity(@PathVariable Long cityId, @PathVariable Long zipcodeId){
        Zipcode zipcode = zipcodeService.removeCityFromZipcode(zipcodeId, cityId);
        return ResponseEntity.ok(zipcode);
    }



}
