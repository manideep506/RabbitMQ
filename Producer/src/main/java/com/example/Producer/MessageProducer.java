package com.example.Producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue queue() {
        return new Queue("myQueue");
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("myQueue", message);
        System.out.println("Message sent: " + message);
    }
}
