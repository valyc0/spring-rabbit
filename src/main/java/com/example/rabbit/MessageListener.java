package com.example.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private final RabbitTemplate rabbitTemplate;
    private final String queue2;

    public MessageListener(RabbitTemplate rabbitTemplate, @Value("${app.queue2}") String queue2) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue2 = queue2;
    }

    @RabbitListener(queues = "${app.queue}")
    public void receive(Payload message) {
        System.out.println("Ricevuto dalla coda 1: " + message);
        rabbitTemplate.convertAndSend(queue2, new Payload(message.text() + " [elaborato]", message.number() + 1));
    }

    @RabbitListener(queues = "${app.queue2}")
    public void receiveProcessed(Payload message) {
        System.out.println("Ricevuto dalla coda 2: " + message);
    }
}
