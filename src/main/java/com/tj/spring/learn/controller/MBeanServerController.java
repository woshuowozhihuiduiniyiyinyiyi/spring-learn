//package com.tj.spring.learn.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.jmx.export.annotation.ManagedResource;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import javax.management.MBeanServer;
//
///**
// * @author tangj
// * @description
// * @since 2019/1/30 10:29
// */
//@RestController
//@ManagedResource

//public class MBeanServerController {
//
//    @Resource
//    private MBeanServer mBeanServer;
//
//    @GetMapping("/mbserver")
//    public ResponseEntity mbServer(){
//        return ResponseEntity.ok(mBeanServer.getMBeanCount());
//    }
//
//}
