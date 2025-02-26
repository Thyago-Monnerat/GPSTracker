package com.kafkaProject.MockGps.services;

import com.kafkaProject.MockGps.dtos.LocalCoordsDTO;
import com.kafkaProject.MockGps.dtos.TravelDTO;
import com.kafkaProject.MockGps.feignClients.GpsClient;
import org.springframework.stereotype.Service;

@Service
public class GpsService {

    private final GpsClient gpsClient;

    public GpsService(GpsClient gpsClient) {
        this.gpsClient = gpsClient;
    }

    public void startTravel(TravelDTO travelDTO) throws InterruptedException {
        gpsClient.sendCoords(travelDTO);

        //Tracking
        double initLat = travelDTO.getInitCoords().getLat();
        double initLon = travelDTO.getInitCoords().getLon();
        double endLat = travelDTO.getFinalCoords().getLat();
        double endLon = travelDTO.getFinalCoords().getLon();

        double percentage = 0.01;

        double calcLat1Percentage = initLat;
        double calcLon1Percentage = initLon;

        for (; percentage < 1.00; percentage += 0.01) {
            gpsClient.sendTracking(new LocalCoordsDTO(calcLat1Percentage, calcLon1Percentage));

            calcLat1Percentage = initLat + (endLat - initLat) * percentage;
            calcLon1Percentage = initLon + (endLon - initLon) * percentage;

            Thread.sleep(5000);
        }
    }
}
