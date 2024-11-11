package com.example.demo.services;

import com.example.demo.models.ProductsInStores;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${application.rabbitmq.exchange}")
    private String exchange;

    @Value("${application.rabbitmq.routingkey}")
    private String routingkey;

    public void send(List<ProductsInStores> storesList) {
        rabbitTemplate.convertAndSend(exchange, routingkey, storesList);
        System.out.println("Send msg = " + storesList);

    }
}
