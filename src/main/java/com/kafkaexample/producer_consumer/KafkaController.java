package com.kafkaexample.producer_consumer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Kafka")
public class KafkaController {
    private KafkaTemplate<String, MessageModel> KafkaTemplate;


    public KafkaController(KafkaTemplate<String, MessageModel> kafkaTemplate) {
        this.KafkaTemplate = kafkaTemplate;

    }

    @PostMapping
    public void post(@RequestBody MessageModel messageModel){
        KafkaTemplate.send("myTopic", messageModel);
    }

}
