package com.tj.spring.learn.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author tangj
 * @description
 * @since 2019/1/29 10:08
 */
@Slf4j
public class QuartzJobCustomize extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
      log.info("sample job.");
    }
}
