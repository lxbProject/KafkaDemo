package com.heima.kafka.boot;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class HelloListener {

    /**
     * 接受消息
     * */
    @KafkaListener(topics = "kafka-demo")
    public void receiveMsg(ConsumerRecord record){
        String msg = (String) record.value();
        System.out.println(msg);
    }
}
