package com.deer.quzrtz.demo;
import com.deer.quzrtz.demo.job.ThreeJob;
import org.quartz.*;
import org.quartz.core.jmx.CronTriggerSupport;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class ThreeTest {
    public static void main(String[] args) throws SchedulerException {
        // First we must get a reference to a scheduler
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        // jobs can be scheduled before start() has been called

        // get a "nice round" time a few seconds in the future...
        Date startTime = DateBuilder.nextGivenSecondDate(null, 2);

        JobDetail job = JobBuilder.newJob(ThreeJob.class)
                .withIdentity("badJob1", "group1")
                .usingJobData("denominator", "0")
                .build();

        //每5秒执行一次
        String corn = "*/5 * * * * ?";
        //  corn表达式  每五秒执行一次
        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("FirstJob", "platform")
                .withSchedule(CronScheduleBuilder.cronSchedule(corn))
                .startNow().build();

        Date ft = sched.scheduleJob(job, trigger);

        //任务每2秒执行一次 那么在BadJob1的方法中拿到的JobDataMap的数据是共享的.
        //这里要注意一个情况： 就是JobDataMap的数据共享只针对一个BadJob1任务。
        //如果在下面在新增加一个任务 那么他们之间是不共享的 比如下面

        JobDetail job2 = JobBuilder.newJob(ThreeJob.class)
                .withIdentity("badJob2", "group2")
                .usingJobData("denominator", "0")
                .build();

        //每5秒执行一次
        String corn2 = "*/5 * * * * ?";
        //  corn表达式  每五秒执行一次
        Trigger trigger2=TriggerBuilder.newTrigger().withIdentity("FirstJob2", "platform2")
                .withSchedule(CronScheduleBuilder.cronSchedule(corn2))
                .startNow().build();

        //这个job2与job执行的JobDataMap不共享
        sched.scheduleJob(job2, trigger2);

        sched.start();

        try {
            // sleep for 30 seconds
            Thread.sleep(30L * 1000L);
        } catch (Exception e) {
        }

        sched.shutdown(false);
    }
}
