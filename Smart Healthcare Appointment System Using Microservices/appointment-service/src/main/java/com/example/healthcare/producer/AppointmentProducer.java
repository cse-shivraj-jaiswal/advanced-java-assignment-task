package com.example.healthcare.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthcare.config.RabbitMQConfig;
import com.example.healthcare.event.AppointmentEvent;

@Service
public class AppointmentProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(AppointmentEvent event) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                event
        );
    }
}
