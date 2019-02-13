package com.tj.spring.learn.controller;

import com.tj.spring.learn.entity.User;
import com.tj.spring.learn.exception.ExceptionCustomize;
import com.tj.spring.learn.service.ServiceCustomize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tangj
 * @description
 * @since 2019/1/21 15:28
 */
@RestController
public class UserController {

    @Resource
    private ServiceCustomize serviceCustomize;

    @GetMapping("/user")
    public ResponseEntity getUser() throws Exception{
        User user = new User();
        user.setAge(18);
        user.setName("tangjie");

        throw new ExceptionCustomize(HttpStatus.FORBIDDEN.value(), "用户错误");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable("id") int id) throws Exception{
        return ResponseEntity.ok(serviceCustomize.getUserById(id));
    }
}
