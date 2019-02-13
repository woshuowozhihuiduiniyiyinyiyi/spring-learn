package com.tj.spring.learn.controlleradvice;

import com.tj.spring.learn.entity.User;
import com.tj.spring.learn.exception.ExceptionCustomize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tangj
 * @since 2019/1/21 17:45
 * 此处为spring boot 标准的统一异常处理，需要在类上@ControllerAdvice 注解。
 * @ExceptionHandler 标注捕获何种异常处理
 */
@ControllerAdvice
public class ControllerAdviceCustomize extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExceptionCustomize.class)
    public ResponseEntity exceptionHandler(ExceptionCustomize exceptionCustomize, HttpServletRequest request){
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("status", exceptionCustomize.getStatus());
        errorMap.put("reason", exceptionCustomize.getReason());

        HttpStatus status = getStatus(request);

        return ResponseEntity.status(exceptionCustomize.getStatus()).body(errorMap);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity validationExceptionHandler(ValidationException validationEx){
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("status", HttpStatus.FORBIDDEN.value());
        errorMap.put("reason", validationEx.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(errorMap);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
