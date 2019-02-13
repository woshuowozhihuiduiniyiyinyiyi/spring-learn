package com.tj.spring.learn.servletinitial;

import com.tj.spring.learn.filter.FilterCustomize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author tangj
 * @description
 * @since 2019/1/22 16:23
 */
@Component
@Slf4j
public class ServletContextInitializerCustomize implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        Object name = servletContext.getAttribute("name");
        log.info("name");
    }
}
