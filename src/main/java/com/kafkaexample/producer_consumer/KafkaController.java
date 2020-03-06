package com.kafkaexample.producer_consumer;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
    private KafkaTemplate<String, String> KafkaTemplate;
    private Gson jsonConverter;

    @Autowired
    public KafkaController(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter) {
        this.KafkaTemplate = kafkaTemplate;
        this.jsonConverter = jsonConverter;
    }

    @PostMapping
    public void post(@RequestBody String message){

        try{
            System.out.println(message);
            String convertedJson = this.jsonConverter.toJson(message);
            System.out.println(convertedJson);
            KafkaTemplate.send("myTopic", convertedJson);
        } catch (Exception ex){
            System.out.println("Exception at Post : " + ex.toString());
        }

    }

    @KafkaListener(topics = "myTopic")
    public void getFromKafka(String messageString){
        try{
            System.out.println(messageString);

            MessageModel messageModel = (MessageModel) jsonConverter.fromJson(messageString, MessageModel.class);
            System.out.println(messageModel.toString());

        } catch(Exception ex){
            System.out.println("Exception at Listener : " + ex.toString());
        }

    }

}
