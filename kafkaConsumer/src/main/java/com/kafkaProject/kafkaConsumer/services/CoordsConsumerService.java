package com.kafkaProject.kafkaConsumer.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CoordsConsumerService {

    private final WebSocketService webSocketService;

    public CoordsConsumerService(WebSocketService webSocketService){
        this.webSocketService = webSocketService;
    }


    @KafkaListener(topics = "travel_topic", groupId = "travel_group")
    public void consumerTravel(String travel){
        webSocketService.sendTravelInfo(travel);
    }

    @KafkaListener(topics = "tracking_topic", groupId = "tracking_group")
    public void consumerTracking(String track){
        webSocketService.sendTracking(track);
    }
}
