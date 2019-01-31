package Main;

import org.quartz.*;

import java.util.Date;

public class Test2 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Мой планировщик");
        System.out.println(new Date());
        //Trigger trigger = TriggerBuilder.newTrigger();
    }
}
