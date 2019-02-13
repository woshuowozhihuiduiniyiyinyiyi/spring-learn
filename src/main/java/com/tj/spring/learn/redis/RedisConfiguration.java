package com.tj.spring.learn.redis;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * @author tangj
 * @since 2019/1/25 10:15
 * <p>
 * spring redis缓存配置类。需要在pom.xml 加上spring data redis 的starter，然后继承CachingConfigurerSupport
 */
@EnableCaching
@Configuration
public class RedisConfiguration extends CachingConfigurerSupport {

    /**
     * 注意：此处只能采用：
     * return RedisCacheConfiguration.defaultCacheConfig()
     * .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringRedisSerializer()))
     * .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer()));
     * 写法，不能是下面这种：
     * RedisCacheConfiguration redisConfiguration = RedisCacheConfiguration.defaultCacheConfig();
     * redisConfiguration.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringRedisSerializer()));
     * redisConfiguration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer()));
     *
     * @return
     */
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer()));
    }

    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }

    @Bean
    public <T> RedisTemplate<String, T> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, T> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(stringRedisSerializer());
        template.setValueSerializer(jackson2JsonRedisSerializer());
        template.setHashKeySerializer(stringRedisSerializer());
        template.setHashValueSerializer(jackson2JsonRedisSerializer());
        return template;
    }

}
