package com.kafkaProject.kafkaProducer.controllers;

import com.kafkaProject.kafkaProducer.dtos.LocalCoordsDTO;
import com.kafkaProject.kafkaProducer.dtos.TravelDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coords")
public class CoordsProducerController {


    private final KafkaTemplate<String, String> kafkaTemplate;

    public CoordsProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("path")
    public ResponseEntity<Void> handleCoords(@RequestBody TravelDTO travelDTO) {
        kafkaTemplate.send("travel_topic", travelDTO.toString());
        return ResponseEntity.ok().build();
    }

    @PostMapping("tracking")
    public ResponseEntity<Void> handleTracking(@RequestBody LocalCoordsDTO localCoordsDTO){
        kafkaTemplate.send("tracking_topic", localCoordsDTO.toString());
        return ResponseEntity.ok().build();
    }
}
