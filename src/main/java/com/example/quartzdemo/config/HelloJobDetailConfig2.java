package com.example.quartzdemo.config;

import com.example.quartzdemo.job.HelloJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * @Description
 * @Author GorryLee
 * @Date 2022/11/24
 */
//@Component
public class HelloJobDetailConfig2 {

    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    protected void InitHelloJob() throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("helloJob")
                .storeDurably()
                .usingJobData("data", "保密信息")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("helloTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withMisfireHandlingInstructionFireNow()
                        .withIntervalInSeconds(3)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail,trigger);

    }
}
