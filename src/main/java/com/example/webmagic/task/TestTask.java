package com.example.webmagic.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author 尹欣
 * @version V1.0
 * @Title: ${Class}
 * @Package ${package_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date ${date} ${time}
 **/
@Component
@DisallowConcurrentExecution
public class TestTask extends QuartzJobBean {

    private Integer num = 1;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {


    }
}
