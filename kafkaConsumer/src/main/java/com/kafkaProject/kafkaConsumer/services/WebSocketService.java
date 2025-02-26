package com.kafkaProject.kafkaConsumer.services;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendTravelInfo(String travel) {
        messagingTemplate.convertAndSend("/topic/travel", travel);
    }

    public void sendTracking(String track){
        messagingTemplate.convertAndSend("/topic/tracking", track);
    }
}