package com.example.quartzdemo.quartz;

import cn.hutool.core.date.DateUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @Description
 * @Author GorryLee
 * @Date 2022/11/23
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        StringJoiner joiner = new StringJoiner(" | ")
                .add("---HelloJob---")
                .add(context.getTrigger().getKey().getName())
                .add(DateUtil.formatDate(new Date()));
        System.out.println(joiner);

    }
}
