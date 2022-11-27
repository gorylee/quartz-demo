package com.example.quartzdemo.config;

import com.example.quartzdemo.job.HelloJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * @Description
 * @Author GorryLee
 * @Date 2022/11/24
 */
//@Component
public class HelloJobDetailConfig {

//    @Bean
//    public JobDetail helloJobDetail(){
//        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
//                .withIdentity("helloJob")
//                .storeDurably()
//                .usingJobData("data", "保密信息")
//                .build();
//        return jobDetail;
//    }
//
//    @Bean
//    public Trigger helloJobTrigger(){
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .forJob("helloJob")
//                .withSchedule(simpleSchedule()
//                        .withIntervalInSeconds(3)
//                        .repeatForever())
//                .build();
//
//        return trigger;
//    }
}
