package com.tj.spring.learn.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangj
 * @description
 * @since 2019/1/21 15:24
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String name;

    private int age;

    private List<String> cars;
}
