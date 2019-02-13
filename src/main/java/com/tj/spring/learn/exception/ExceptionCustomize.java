package com.tj.spring.learn.exception;

import lombok.Data;

/**
 * @author tangj
 * @description
 * @since 2019/1/21 17:48
 */
@Data
public class ExceptionCustomize extends RuntimeException{

    public ExceptionCustomize(Integer status, String reason) {
        this.reason = reason;
        this.status = status;
    }

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 异常原因
     */
    private String reason;
}
