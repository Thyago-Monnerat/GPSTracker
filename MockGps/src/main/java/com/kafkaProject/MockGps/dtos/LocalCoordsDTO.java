package com.kafkaProject.MockGps.dtos;

import lombok.Data;

@Data
public class LocalCoordsDTO {
    private double lat;
    private double lon;

    public LocalCoordsDTO(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
    }
}
