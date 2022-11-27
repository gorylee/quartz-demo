package com.example.quartzdemo.job;

import cn.hutool.core.date.DateUtil;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @Description
 * @Author GorryLee
 * @Date 2022/11/24
 */
public class HelloJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context)  {
        StringJoiner joiner = new StringJoiner(" | ")
                .add("---HelloJob---")
                .add(context.getTrigger().getKey().getName())
                .add((String)context.getJobDetail().getJobDataMap().get("data"))
                .add(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        System.out.println(joiner);

    }
}
