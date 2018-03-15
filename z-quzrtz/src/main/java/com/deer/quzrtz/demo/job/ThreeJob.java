package com.deer.quzrtz.demo.job;

import org.quartz.*;

import java.time.LocalDateTime;

//@PersistJobDataAfterExecution  //保存JobDataMap 中的值
//@DisallowConcurrentExecution   //如果每2秒执行一次 job需要执行5秒 开启注解 不并发执行相同的JOb
public class ThreeJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        int denominator = dataMap.getInt("denominator");
        System.out.println("---" + jobKey + " executing at " + LocalDateTime.now().toString()+ " with denominator " + denominator);

        denominator++;
        dataMap.put("denominator", denominator);
    }
}
