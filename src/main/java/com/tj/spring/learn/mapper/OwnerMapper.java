package com.tj.spring.learn.mapper;

import com.tj.spring.learn.entity.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * @author tangj
 * @since 2019/1/23 11:49
 *
 * spring data jpa 支持，需要 在pom文件加上
    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
 引入spring boot data jpa 的starter，同时CrudRepository 类中提供了常用 的crud 方法
 */
public interface OwnerMapper extends CrudRepository<Owner, Integer> {
}
