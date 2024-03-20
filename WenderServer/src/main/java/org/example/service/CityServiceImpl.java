package org.example.service;

import org.example.entity.City;
import org.example.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> getAllCities() {
        return cityMapper.getAllCities();
    }
}