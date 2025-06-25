package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository repository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll(){
        List<City> city = repository.findAll(Sort.by("name"));
        return city.stream().map(x -> new CityDTO(x)).toList();
    }

    @Transactional(readOnly = false)
    public CityDTO insert(CityDTO dto){
        City city = new City();
        city.setName(dto.getName());

        city = repository.save(city);
        return new CityDTO(city);
    }
}
