package com.kafkaProject.MockGps.feignClients;


import com.kafkaProject.MockGps.dtos.LocalCoordsDTO;
import com.kafkaProject.MockGps.dtos.TravelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "gpsClient", url="http://localhost:8080/coords")
public interface GpsClient {

    @PostMapping("path")
    void sendCoords(@RequestBody TravelDTO travelDTO);

    @PostMapping("tracking")
    void sendTracking(@RequestBody LocalCoordsDTO localCoordsDTO);
}
