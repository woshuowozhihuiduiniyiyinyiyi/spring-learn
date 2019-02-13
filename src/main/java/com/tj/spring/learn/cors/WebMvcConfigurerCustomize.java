package com.tj.spring.learn.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author tangj
 * @since 2019/1/22 9:32
 *
 * spring boot 标准cors 跨域支持，需要自己定义一个WebMvcConfigurer 的bean。
 */
@Configuration
public class WebMvcConfigurerCustomize {

    @Bean
    public WebMvcConfigurer getWebMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry corsRegistry){
                corsRegistry.addMapping("/api/**");
            }
        };
    }
}
