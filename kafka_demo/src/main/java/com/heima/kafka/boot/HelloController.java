package com.heima.kafka.boot;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 生产者
 * */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    /**
     * 发送消息乐乐乐乐
     *
     * */
    @GetMapping
    public String hello(){
        kafkaTemplate.send("kafka-demo","黑马程序员");
        return "ok";
    }

    /**
     *111222
     * */
    @GetMapping("bean")
    public String hello2(){
        User jack = new User("jack", 18);
        String value = JSON.toJSONString(jack);
        kafkaTemplate.send("kafka-demo",value);
        return "发送成功";
    }

    /**
     * 注释说明111
     * */
}
