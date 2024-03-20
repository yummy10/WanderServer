package org.example.mapper;

import org.example.entity.Place;

import java.util.List;

public interface PlaceMapper {
    List<Place> getAllPlaces();
    void addPlace(Place place);
    List<Place> searchPlacesByName(String name);
    List<Place> searchPlacesByCity(String cityName);
}
