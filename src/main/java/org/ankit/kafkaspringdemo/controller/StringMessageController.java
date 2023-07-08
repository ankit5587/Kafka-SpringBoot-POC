package org.ankit.kafkaspringdemo.controller;

import org.ankit.kafkaspringdemo.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class StringMessageController {

    private KafkaProducer kafkaProducer;

    public StringMessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //http:locathost:8080/api/vi/kafka/publish?message=Hello
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){

        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message has been produced");

    }
}
