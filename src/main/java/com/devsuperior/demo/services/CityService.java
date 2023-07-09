package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository repository;

    public List<CityDTO> findAll() {
        List<CityDTO> result = repository.findAll()
                .stream().sorted((a,b)->a.getName().compareTo(b.getName()))
                .map(x -> new CityDTO(x)).toList();

        return result;
    }

    public CityDTO insert(CityDTO dto) {
        City city = new City();
        city.setName(dto.getName());
        city = repository.save(city);
        return new CityDTO(city);
    }
}
