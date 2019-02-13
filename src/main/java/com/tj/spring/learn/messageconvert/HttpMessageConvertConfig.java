package com.tj.spring.learn.messageconvert;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.nio.charset.Charset;

/**
 * @author tangj
 * @since 2019/1/21 14:23
 *
 * spring boot 的消息转换，也即序列化，自己定义了序列化特性配置。
 */
@Configuration
public class HttpMessageConvertConfig {

    @Bean
    public HttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        SerializerFeature[] serializerFeatures = new SerializerFeature[]{
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteNullStringAsEmpty
        };

        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastJsonConfig.setSerializerFeatures(serializerFeatures);

        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        return fastJsonHttpMessageConverter;
    }

}
