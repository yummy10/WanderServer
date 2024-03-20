package org.example.controller;

import org.example.entity.City;
import org.example.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return cities;
    }

    @GetMapping(value = "/images/{imagePath1}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable("imagePath1") String imagePath1) throws IOException {
        File file = new File("src/main/resources/images/city/" + imagePath1+".jpg");
        if (file.exists()) {
            return Files.readAllBytes(file.toPath());
        } else {
            throw new FileNotFoundException("Image not found: " + imagePath1);
        }
    }
}