package com.tj.spring.learn.banner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * @author tangj
 * @description
 * @since 2019/1/16 9:25
 */
@Slf4j
public class BannerCustomize implements Banner {
    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        log.info("BannerCustomize printBanner.");
    }
}
