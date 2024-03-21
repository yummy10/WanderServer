package org.example.controller;

import org.example.entity.Place;
import org.example.entity.PlaceRequest;
import org.example.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.http.CacheControl;

import javax.servlet.ServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<Place> getAllPlaces() {
        List<Place> places = placeService.getAllPlaces();
        return places;
    }

    @PostMapping
    public void addPlace(@RequestBody PlaceRequest placeRequest) {
        Place place=placeRequest.getPlace();
        String cityName=placeRequest.getPlaceName();
        String imageName = place.getPlaceName().replace(" ", "_");
        place.setPlaceImageName(imageName);
        place.setPlaceImagePath("places/images/"+cityName+"/"+place.getPlaceImageName()+".jpg");
        placeService.addPlace(place);
    }

    @GetMapping("/search")
    public List<Place> searchPlaces(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String city) {
        List<Place> places;
        if (name != null) {
            places = placeService.searchPlacesByName(name);
        } else if (city != null) {
            places = placeService.searchPlacesByCity(city);
        } else {
            places = Collections.emptyList();
        }
        return places;
    }

    @GetMapping(value = "/images/{imagePath1}/{imagePath2}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable("imagePath1") String imagePath1, @PathVariable("imagePath2") String imagePath2) throws IOException {
        File file = new File("src/main/resources/images/place/" + imagePath1+"/"+imagePath2+".jpg");
        if (file.exists()) {
            return Files.readAllBytes(file.toPath());
        } else {
            throw new FileNotFoundException("Image not found: " + imagePath1+"/"+imagePath2);
        }
    }

}