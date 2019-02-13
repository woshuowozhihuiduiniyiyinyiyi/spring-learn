package com.tj.spring.learn.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tangj
 * @description
 * @since 2019/2/12 11:25
 */
@Configuration
public class ConditionalOnMissBeanCustomize {

    /**
     * conditionalOnMissBean 是只有在ioc 中没有Computer 类的bean 时，才会注入RevertComputer 这个bean
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(Computer.class)
    public RevertComputer revertComputer() {
        RevertComputer revertComputer = new RevertComputer();
        revertComputer.setId(2);
        revertComputer.setName("revert Computer");
        return revertComputer;
    }

    @Bean
    public Computer computer() {
        Computer computer = new Computer();
        computer.setCpu("Intenal");

        return computer;
    }

}
