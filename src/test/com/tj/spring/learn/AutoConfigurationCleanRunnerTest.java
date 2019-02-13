package com.tj.spring.learn;

import com.tj.spring.learn.autoconfig.Computer;
import com.tj.spring.learn.autoconfig.ConditionalOnMissBeanCustomize;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import java.util.Optional;


/**
 * @author tangj
 * @description
 * @since 2019/2/13 9:37
 */
@Slf4j
public class AutoConfigurationCleanRunnerTest {

    /**
     * 这里可以定义 一个干净的测试环境 ，不会加载自动配置，也就不会被自动 配置所影响。
     */
    private final ApplicationContextRunner applicationContextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(ConditionalOnMissBeanCustomize.class));

    @Test
    public void testComputerAutoconfig() {
        this.applicationContextRunner.withPropertyValues("computer.name=Intel").run((context -> {
            boolean hasComputer = Optional.ofNullable(context).get().containsBean("computer");
            log.info("hasComputer:{}", hasComputer);
        }));
    }
}
