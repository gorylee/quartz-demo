package com.example.quartzdemo.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Description
 * @Author GorryLee
 * @Date 2022/11/23
 */
public class QuartzTest {

    public static void main(String[] args) throws Exception{
        try {

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();


            scheduler.start();
            JobDetail job = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(2)
                            .repeatForever())
                    .build();

            JobDetail job2 = newJob(HelloJob.class)
                    .withIdentity("job2", "group2")
                    .build();

            Trigger trigger2 = newTrigger()
                    .withIdentity("trigger2", "group2")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(4)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(job, trigger);
            scheduler.scheduleJob(job2, trigger2);

            TimeUnit.SECONDS.sleep(20);
            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
