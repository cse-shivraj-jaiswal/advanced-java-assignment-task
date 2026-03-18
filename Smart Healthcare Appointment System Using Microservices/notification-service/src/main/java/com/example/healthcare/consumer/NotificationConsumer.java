package com.example.healthcare.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.healthcare.dto.AppointmentEvent;

@Service
public class NotificationConsumer {

    @RabbitListener(queues = "appointment.queue")
    public void receiveMessage(AppointmentEvent event) {
        System.out.println("📩 Notification Received: " + event.getMessage());
    }
}
