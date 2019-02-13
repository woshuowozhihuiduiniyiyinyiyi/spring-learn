package com.tj.spring.learn.service;

import com.tj.spring.learn.entity.User;
import com.tj.spring.learn.properties.PropertiesCustomize;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author tangj
 * @description
 * @since 2019/1/17 17:50
 */
@Component
@EnableConfigurationProperties(PropertiesCustomize.class)
public class ServiceCustomize {

    @Resource
    private PropertiesCustomize propertiesCustomize;

    public String getPropertiesCustomizeStr(){
        return propertiesCustomize.toString();
    }

    @Cacheable("user")
    public User getUserById(int id){
        User user = new User();
        user.setId(id);
        user.setName("tangjie");
        return user;
    }
}
