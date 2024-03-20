package org.example.service;

import org.example.entity.Place;
import org.example.mapper.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceMapper placeMapper;

    @Override
    public List<Place> getAllPlaces() {
        return placeMapper.getAllPlaces();
    }

    @Override
    public void addPlace(Place place) {
        placeMapper.addPlace(place);
    }

    @Override
    public List<Place> searchPlacesByName(String name) {
        return placeMapper.searchPlacesByName(name);
    }

    @Override
    public List<Place> searchPlacesByCity(String cityName) {
        return placeMapper.searchPlacesByCity(cityName);
    }
}
