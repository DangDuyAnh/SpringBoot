package com.example.demo.kafka;

import com.example.demo.kafka.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "topic1", groupId = "groupId", containerGroup = "messageFactory")
    void listener(Message data) {
        System.out.println("Listener received: " + data + " ");
    }

} // The End of Class;
