package com.tj.spring.learn.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author tangj
 * @description 此处定义 的filter 需要在启动点的@ServletComponentScan 中指定才能生效
 * @since 2019/1/22 16:25
 */
@Slf4j
@WebFilter(filterName = "filterCustomize",urlPatterns = "/*")
public class FilterCustomize implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("name");
        log.info("name:{}", name);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
