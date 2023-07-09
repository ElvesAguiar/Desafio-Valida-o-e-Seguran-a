package com.devsuperior.demo.controller;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CityRepository;
import com.devsuperior.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "cities")
public class CityController {
    @Autowired
    private CityService service;

    @GetMapping
    public List<CityDTO> findAlll(){
        return service.findAll();
    };

    @PostMapping
    public CityDTO insert(@RequestBody CityDTO dto){
        return service.insert(dto);
    };
}
