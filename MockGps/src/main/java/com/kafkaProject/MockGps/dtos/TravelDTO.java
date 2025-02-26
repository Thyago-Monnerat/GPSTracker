package com.kafkaProject.MockGps.dtos;

import lombok.Data;

@Data
public class TravelDTO {
    private LocalCoordsDTO initCoords;
    private LocalCoordsDTO finalCoords;

    public TravelDTO(LocalCoordsDTO initCoords, LocalCoordsDTO finalCoords) {
        this.initCoords = initCoords;
        this.finalCoords = finalCoords;
    }
}