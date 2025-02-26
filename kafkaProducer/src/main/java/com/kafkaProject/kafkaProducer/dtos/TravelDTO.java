package com.kafkaProject.kafkaProducer.dtos;

import lombok.Data;

@Data
public class TravelDTO {
    private LocalCoordsDTO initCoords;
    private LocalCoordsDTO finalCoords;

    @Override
    public String toString(){
        return "{\n\"initCoords\":" + initCoords + ",\n\"finalCoords\": " + finalCoords + "\n}";
    }
}