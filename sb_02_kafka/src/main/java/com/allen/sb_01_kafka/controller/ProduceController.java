package com.allen.sb_01_kafka.controller;

import com.allen.sb_01_kafka.bean.Log;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/send/kafka")
public class ProduceController {

    @Autowired
    private KafkaTemplate<String, String> template;

    @RequestMapping("/sync")
    public String syncSend(@RequestBody String message) {
        ListenableFuture<SendResult<String, String>> future = template.send("app-log-ods", 0, message, message);
        try {
            SendResult<String, String> result = future.get();
            RecordMetadata metadata = result.getRecordMetadata();
            System.out.println(metadata.topic() + "\t" + metadata.partition() + "\t" + metadata.offset());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("/async")
    public String asyncSend(@RequestBody String message) throws JsonProcessingException {
        ObjectMapper jsonMapper = new ObjectMapper();
        Log log = jsonMapper.readValue(message, Log.class);
        String topic = template.getDefaultTopic();
        ListenableFuture<SendResult<String, String>> future = template
                .send(topic, 3, log.getUserId(), message.toString());
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                RecordMetadata metadata = result.getRecordMetadata();
                System.out.println("send successfully:" +
                        metadata.topic() + "\t" + metadata.partition() + "\t" + metadata.offset());
            }
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("send failed :" + throwable.getMessage());
            }
        });
        return "success";
    }

}
