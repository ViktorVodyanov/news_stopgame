package Main;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Test {
    public static void main(String[] args) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(Test2.class).build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("CroneTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(02).repeatForever()).build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.start();

        scheduler.scheduleJob(job, trigger);

    }
}
