package com.heima.kafka.boot;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * */
@Component
public class HelloConsumer {
    /**
     * 接受普通字符串
     * */
    @KafkaListener(topics = "kafka-demo")
    public void receiveMsg(ConsumerRecord<String,String> record){
        if (record != null){
            String value = record.value();
            System.out.println("消息内容:"+value);
        }
    }

    /**
     * 接受对象字符串消息
     * */
    @KafkaListener(topics = "kafka-demo")
    public void receiveMsg2(ConsumerRecord<String,String> record){
        if (record != null){
            String value = record.value();
            //将json字符串转换为对象
            User user = JSON.parseObject(value, User.class);
            System.out.println("消息内容bean:"+user);
        }
    }

}
