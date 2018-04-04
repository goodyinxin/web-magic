package com.example.webmagic.task;

import com.example.webmagic.service.MeiShiChinaService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
* @Title: MeiShiChinaTask
* @Package com.example.webmagic.task
* @Description: ${todo}(用一句话描述该文件做什么)
* @author 尹欣
* @date 2018/4/2 15:38
* @version V1.0 
**/
@Slf4j
@Component
@DisallowConcurrentExecution
public class MeiShiChinaTask extends QuartzJobBean {

    @Autowired
    private MeiShiChinaService meiShiChinaService;

    public MeiShiChinaTask(){
        log.info("-------------------------MeiShiChinaTask---------------------------------"+meiShiChinaService);
    }


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        meiShiChinaService.excute();
    }
}
