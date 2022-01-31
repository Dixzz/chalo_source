package server.zophop.cron;

import j$.util.DesugarTimeZone;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import server.zophop.models.SimpleLogger;

public class ConfigClass {
    public static void main(String[] strArr) {
        try {
            Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
            defaultScheduler.start();
            defaultScheduler.scheduleJob(JobBuilder.newJob(UrlTriggerJob.class).usingJobData("url", "http://gpsfeed.zophop2013.appspot.com/trigger/kolkata/kp").build(), TriggerBuilder.newTrigger().startNow().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)).build());
        } catch (Exception e) {
            SimpleLogger.logException(e);
        }
        try {
            Scheduler defaultScheduler2 = StdSchedulerFactory.getDefaultScheduler();
            defaultScheduler2.start();
            defaultScheduler2.scheduleJob(JobBuilder.newJob(UrlTriggerJob.class).usingJobData("url", "http://gpsfeed.zophop2013.appspot.com/trigger/delhi/dimts").build(), TriggerBuilder.newTrigger().startNow().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)).build());
        } catch (Exception e2) {
            SimpleLogger.logException(e2);
        }
        try {
            Scheduler defaultScheduler3 = StdSchedulerFactory.getDefaultScheduler();
            defaultScheduler3.start();
            defaultScheduler3.scheduleJob(JobBuilder.newJob(UrlTriggerJob.class).usingJobData("url", "http://gpsfeed.zophop2013.appspot.com/trigger/fetch-data/cstc").build(), TriggerBuilder.newTrigger().startNow().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(10)).build());
        } catch (Exception e3) {
            SimpleLogger.logException(e3);
        }
        try {
            Scheduler defaultScheduler4 = StdSchedulerFactory.getDefaultScheduler();
            defaultScheduler4.start();
            defaultScheduler4.scheduleJob(JobBuilder.newJob(UrlTriggerJob.class).usingJobData("url", "http://production.zophop2013.appspot.com/cache/flush").build(), TriggerBuilder.newTrigger().startNow().withSchedule(CronScheduleBuilder.cronSchedule("0 30 23 ? * *").inTimeZone(DesugarTimeZone.getTimeZone("IST"))).build());
        } catch (Exception e4) {
            SimpleLogger.logException(e4);
        }
    }
}
