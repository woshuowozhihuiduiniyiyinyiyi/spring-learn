package com.tj.spring.learn.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tangj
 * @since 2019/1/17 15:52
 *
 * spring 自定义属性配置，可以从配置文件中自动加载。使用@ConfigurationProperties 指定属性，同时，需要使用属性配置类时，需要加上@EnableConfigurationProperties 注解。
 */
@Data
@ConfigurationProperties(prefix = "tj.properties")
public class PropertiesCustomize {

    private String name ;

    private Integer age ;
}
