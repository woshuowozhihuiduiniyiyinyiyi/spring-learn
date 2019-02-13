package com.tj.spring.learn;

import com.tj.spring.learn.autoconfig.RevertComputer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author tangj
 * @description
 * @since 2019/2/12 11:31
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AutoConfigurationTest {

    @Resource
    private RevertComputer revertComputer;

    @Test
    public void testConditionalOnMissBean() {
        Integer id = revertComputer.getId();
        log.info("the id is:{}", id);
    }
}
