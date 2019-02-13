package com.tj.spring.learn;

import com.tj.spring.learn.autoconfig.RevertComputer;
import com.tj.spring.learn.filter.FilterCustomize;
import com.tj.spring.learn.service.ServiceCustomize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tangj
 * @description
 * @since 2019/1/14 17:53
 */
@Slf4j
@RestController
@SpringBootApplication(scanBasePackages = "com.tj.spring.learn")
@ServletComponentScan(basePackageClasses = FilterCustomize.class)
public class SpringLearnApplication {

    @Resource
    private ServiceCustomize serviceCustomize;

    @RequestMapping("/")
    public String home() {
        log.info("properties customize:{}", serviceCustomize.getPropertiesCustomizeStr());
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }
}
