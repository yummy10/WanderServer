package org.example.entity;


public class Place {
    private Integer placeId;
    private String placeName;
    private String placeDescription;
    private String placeIntroduction;
    private Integer cityId;
    private String placeImageName;
    private String placeImagePath;

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public String getPlaceIntroduction() {
        return placeIntroduction;
    }

    public void setPlaceIntroduction(String placeIntroduction) {
        this.placeIntroduction = placeIntroduction;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getPlaceImageName() {
        return placeImageName;
    }

    public void setPlaceImageName(String placeImageName) {
        this.placeImageName = placeImageName;
    }

    public String getPlaceImagePath() {
        return placeImagePath;
    }

    public void setPlaceImagePath(String placeImagePath) {
        this.placeImagePath = placeImagePath;
    }
}
