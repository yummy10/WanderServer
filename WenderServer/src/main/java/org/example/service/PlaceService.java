package org.example.service;

import org.example.entity.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAllPlaces();
    void addPlace(Place place);
    List<Place> searchPlacesByName(String name);
    List<Place> searchPlacesByCity(String cityName);
}