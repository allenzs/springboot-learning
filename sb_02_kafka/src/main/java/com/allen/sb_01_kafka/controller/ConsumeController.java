package com.allen.sb_01_kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumeController {

    @KafkaListener(topics = "dragon_stream_source_zhangshuai")
    public void onMessage(ConsumerRecord<String, String> record) {
        String msg = record.topic() + "\t" +
                record.partition() + "\t" +
                record.offset() + "\t" +
                record.key() + "\t" +
                record.value() + "\t";
        System.out.println(msg);
    }
}
