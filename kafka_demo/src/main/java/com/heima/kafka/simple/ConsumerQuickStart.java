package com.heima.kafka.simple;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;

/**
 * 消息生消费者
 */
public class ConsumerQuickStart {

    private static final String TOPIC = "itcast-heima";

    public static void main(String[] args) {
        //1.配置连接参数
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.66.133:9092");//连接Kafka地址
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");//key反序列化类
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");//value反序列化类
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"group1");// 消费者组名

        /**
         * 关于消费者名称：
         *     如果要实现Kafka的广播模式（多个消费者同时接受消息），所有消费者订阅同一个主题，但组名必须不同
         *     如果要实现Kafka的集群模式（多个消费者只能有一个消费者接受消息），所有消费者订阅同一个主题，但组名必须相同
         */

        //2.创建消费者对象
        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer(properties);

        //3.订阅主题
        kafkaConsumer.subscribe(Collections.singleton(TOPIC));

        //4.接受消息
        while(true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(1000));
            //取出消息
            Iterator<ConsumerRecord<String, String>> iterator = consumerRecords.iterator();

            //遍历每一条消息
            while(iterator.hasNext()){
                //ConsumerRecord: 代表1条消息
                ConsumerRecord<String, String> record = iterator.next();
                String key = record.key();
                String value = record.value();
                System.out.println("key="+key);
                System.out.println("value="+value);
            }
        }
    }

}