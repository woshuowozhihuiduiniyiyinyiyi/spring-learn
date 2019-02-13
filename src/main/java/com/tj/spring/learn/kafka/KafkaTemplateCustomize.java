//package com.tj.spring.learn.kafka;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @author tangj
// * @since 2019/1/26 9:41
// *
// * 此处使用spring-kafka 进行整合kafka.需要在pom.xml 文件中添加
// * <dependency>
//    <groupId>org.springframework.kafka</groupId>
//    <artifactId>spring-kafka</artifactId>
//    <version>2.2.3.RELEASE</version>
//    </dependency>
//    依赖，同时，需要在配置文件中进行kafka相应配置，如序列化或者反序列化相关配置。
//    spring boot 自动配置了KafkaTemplate ，可用于进行消息发送，同时可使用@KafkaListener 进行指定话题进行消费。
// */
////@Component
////@Slf4j
////public class KafkaTemplateCustomize {
////
////    @Resource
////    private KafkaTemplate kafkaTemplate;
////
////    public void sendMessage(String key, String message){
////        kafkaTemplate.send("test", key, message);
////    }
////
////    @KafkaListener(topics="test")
////    public void getMessage(String content){
////        log.info("kafka receive message:{}", content);
////    }
////}
