package com.example.webmagic.controller;

import com.example.webmagic.bean.JobBean;
import com.example.webmagic.bean.Msg;
import com.example.webmagic.bean.SchedulerManager;
import org.apache.commons.lang3.StringUtils;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerKey;
import org.quartz.impl.StdScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Title: controller
* @Package com.example.webmagic
* @Description: ${todo}(用一句话描述该文件做什么)
* @author 尹欣
* @date 2018/3/28 10:43
* @version V1.0
**/
@Controller
public class IndexController {

    public static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    @Qualifier("Scheduler")
    private Scheduler scheduler;

    @Qualifier("quartzScheduler")
    private SchedulerFactoryBean schedulerFactoryBean;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }


    /**
     *
     * 列表展示定时任务
     *
     * @param request
     * @return
     */
    @GetMapping("/taskList")
    @ResponseBody
    public Msg scheduleList(HttpServletRequest request) {
        log.info("------ tasklist ------");
        Map<String, Object> model = new HashMap<String, Object>();
        try {
            // 获得任务调度管理
            SchedulerManager schedulerManager = getSchedul(request);
            if (schedulerManager != null) {
                List<JobBean> jobList = new ArrayList<JobBean>();
                List<JobDetail> jobDetails = schedulerManager.listAllJobs();
                if (null != jobDetails) {
                    for (JobDetail jobDetail : jobDetails) {
                        JobBean jobBean = new JobBean();
                        jobBean.setJobName(jobDetail.getKey().getName());
                        jobBean.setJobGroup(jobDetail.getKey().getGroup());
                        jobBean.setCronExpression(schedulerManager.getCroByJob(jobBean));
                        TriggerKey triggerKey = TriggerKey.triggerKey(jobDetail.getKey().getName(),
                                jobDetail.getKey().getGroup());
                        jobBean.setJobStatus(schedulerManager.getTriggerState(triggerKey));
                        jobBean.setPreviousFireTime(schedulerManager.getPreviousFireTime(triggerKey));
                        jobBean.setNextFireTime(schedulerManager.getNextFireTime(triggerKey));
                        jobBean.setJobClazz(jobDetail.getJobClass().toString().substring(5).trim());
                        jobBean.setDesc(jobDetail.getDescription());
                        // log.info(jobBean.toString());
                        jobList.add(jobBean);
                    }
                }
                model.put("jobList", jobList);
                return new Msg().success().add("jobList", jobList);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }


    /*添加定时任务*/
    @PostMapping("/addJob")
    public String addJob(JobBean jobBean, HttpServletRequest request) {
        // 加载定时任务配置文件
        try {
            log.info("addJob    " + jobBean.toString());
            SchedulerManager schedulerManager = getSchedul(request);
            if (StringUtils.isNotBlank(jobBean.getJobName().trim()) && StringUtils.isNotBlank(jobBean.getJobGroup().trim())
                    && StringUtils.isNotBlank(jobBean.getJobClazz())) {
                schedulerManager.addJob(jobBean);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "redirect:/";
    }

    /**
     *
     * 得到任务调度器管理
     *
     * @param request
     * @return
     */
    private SchedulerManager getSchedul(HttpServletRequest request) {
        // 实例化调度工具
        SchedulerManager schedulerManager = null;
        try {
            // 获得SringCongtext上下文
           //ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            // 得到调度器
           // StdScheduler scheduler = (StdScheduler) applicationContext.getBean("quartzScheduler");

            StdScheduler stScheduler = (StdScheduler) scheduler;
            schedulerManager = new SchedulerManager(stScheduler);
        } catch (BeansException e) {
            log.error(e.getMessage(), e);
        }
        return schedulerManager;
    }



    @RequestMapping(method = RequestMethod.GET, value = "/resumeJob")
    public String resumeJob(JobBean jobBean, HttpServletRequest request) {
        // 加载定时任务配置文件
        try {
            jobBean.setJobName(jobBean.getJobName().trim());
            jobBean.setJobGroup(jobBean.getJobGroup().trim());
            SchedulerManager schedulerManager = getSchedul(request);
            if (StringUtils.isNotBlank(jobBean.getJobName().trim()) && StringUtils.isNotBlank(jobBean.getJobGroup().trim())) {
                schedulerManager.resumeJob(jobBean);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "redirect:/";
    }



    /**
     * 定时任务暂停
     *
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pauseJob")
    public String pauseJob(JobBean jobBean, HttpServletRequest request) {
        try {
            // 加载定时任务配置文件
            jobBean.setJobName(jobBean.getJobName().trim());
            jobBean.setJobGroup(jobBean.getJobGroup().trim());
            SchedulerManager schedulerManager = getSchedul(request);
            if (StringUtils.isNotBlank(jobBean.getJobName().trim()) && StringUtils.isNotBlank(jobBean.getJobGroup().trim())) {
                schedulerManager.pauseJob(jobBean);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "redirect:/";
    }



    /**
     * 修改定时任务
     *
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/editJob")
    @ResponseBody
    public Msg editJob(JobBean jobBean, HttpServletRequest request) {
        try {
            // 加载定时任务配置文件
            log.info("editJob" + jobBean.toString());
            SchedulerManager schedulerManager = getSchedul(request);
            if (StringUtils.isNotBlank(jobBean.getJobName().trim()) && StringUtils.isNotBlank(jobBean.getJobGroup().trim())) {
                schedulerManager.addJob(jobBean);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return new Msg().success();
    }


    /**
     * 删除定时任务
     *
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/removeJob")
    public String removeJob(JobBean jobBean, HttpServletRequest request) {
        // 加载定时任务配置文件
        log.info("removeJob" + jobBean.toString());
        try {
            jobBean.setJobName(jobBean.getJobName().trim());
            jobBean.setJobGroup(jobBean.getJobGroup().trim());
            SchedulerManager schedulerManager = getSchedul(request);
            if (StringUtils.isNotBlank(jobBean.getJobName().trim()) && StringUtils.isNotBlank(jobBean.getJobGroup().trim())) {
                schedulerManager.removeJob(jobBean);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "redirect:/";
    }

    public static void main(String[] args) {
        System.out.println("=====================通过java来获取相关系统状态====================");
        long i = Runtime.getRuntime().totalMemory()/1024/1024;//Java 虚拟机中的内存总量，以字节为单位
        System.out.println("总的内存量为:" + i + "Mb");
        long j = Runtime.getRuntime().freeMemory()/1024/1024;//Java 虚拟机中的空闲内存量
        System.out.println("空闲内存量:" + j + "Mb");
        long k = Runtime.getRuntime().maxMemory()/1024/1024;
        System.out.println("最大可用内存量:" + k + "Mb");

    }
}
