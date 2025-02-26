package com.kafkaProject.kafkaProducer.dtos;

import lombok.Data;

@Data
public class LocalCoordsDTO {
    private double lat;
    private double lon;

    @Override
    public String toString(){
        return "{\n \"lat\": " + lat + ",\n\"lon\": " + lon + "\n }";
    }
}
