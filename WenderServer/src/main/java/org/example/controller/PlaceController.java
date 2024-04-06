package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Place;
import org.example.entity.PlaceRequest;
import org.example.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @PostMapping("/addWithImage")
    public void addPlaceWithImage(@RequestPart("place") String placeJson,
                                  @RequestPart("currentCityName") String currentCityName,
                                  @RequestPart("image") MultipartFile file) throws IOException {
        // 將JSON字符串轉換為Place對象
        Place place = new ObjectMapper().readValue(placeJson, Place.class);
        currentCityName = currentCityName.substring(1, currentCityName.length() - 1).toLowerCase();
        // 處理圖片上傳
        if (!file.isEmpty()) {
            String imageName = place.getPlaceName().replace(" ", "_");
            String imagePath = "images/place/" + currentCityName+"/"+ imageName + ".jpg";
            File imageFile = new File("C:/Wander/WenderServer/WenderServer/src/main/resources/" + imagePath);
            file.transferTo(imageFile.toPath());
            place.setPlaceImageName(imageName);
            place.setPlaceImagePath(imagePath);
        } else {
            throw new IllegalStateException("Cannot upload empty file");
        }

        // 將地點添加到數據庫
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
    @PostMapping(value = "/add")
    public void addPlace(@RequestBody PlaceRequest placeRequest) {
        Place place=placeRequest.getPlace();
        String imageName = place.getPlaceName().replace(" ", "_");
        place.setPlaceImageName(imageName);
        place.setPlaceImagePath("");
        placeService.addPlace(place);
    }
}