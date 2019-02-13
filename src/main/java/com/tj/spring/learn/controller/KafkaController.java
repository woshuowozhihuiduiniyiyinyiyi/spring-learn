//package com.tj.spring.learn.controller;
//
//import com.tj.spring.learn.kafka.KafkaTemplateCustomize;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * @author tangj
// * @description
// * @since 2019/1/26 9:55
// */
//@RestController
//public class KafkaController {
//
//    @Resource
//    private KafkaTemplateCustomize kafkaTemplateCustomize;
//
//    @GetMapping("/kafka/send/{message}")
//    public ResponseEntity kafkaSendMessage(@PathVariable("message") String message){
//        kafkaTemplateCustomize.sendMessage("testKey", message);
//        return ResponseEntity.ok().build();
//    }
//
//}
