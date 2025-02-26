package com.kafkaProject.MockGps;

import com.kafkaProject.MockGps.dtos.LocalCoordsDTO;
import com.kafkaProject.MockGps.dtos.TravelDTO;
import com.kafkaProject.MockGps.services.GpsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Scanner;

@SpringBootApplication
@EnableFeignClients
public class MockGpsApplication implements CommandLineRunner {

    private final GpsService gpsService;

    public MockGpsApplication(GpsService gpsService) {
        this.gpsService = gpsService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MockGpsApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Scanner scan = new Scanner(System.in);

        // Santos Dumont airport
        double initLat = -22.9105;
        double initLon = -43.1631;

        //Congonhas airport
        double finalLat = -23.6264;
        double finalLon = -46.6563;

        LocalCoordsDTO initialCoords = new LocalCoordsDTO(initLat, initLon);
        LocalCoordsDTO finalCoords = new LocalCoordsDTO(finalLat, finalLon);

        System.out.println("Digite y para iniciar o gps");
        String start = scan.next();
        scan.close();

        if(start.equals("y")){
            gpsService.startTravel(new TravelDTO(initialCoords, finalCoords));
        }else{
            System.exit(0);
        }
    }
}
