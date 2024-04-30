package com.example.Producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/send-message")
    public String sendMessage(@RequestBody String message) {
        messageProducer.sendMessage(message);
        return "Message sent: " + message;
    }
}
