package server.zophop.cron;

import com.firebase.client.Firebase;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import server.zophop.models.SimpleLogger;
import server.zophop.queue.UnfinishedTasks;

public class UnfinishedTaskHandler implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleLogger.warning("Un finished job");
        new UnfinishedTasks(new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production")).execute();
    }
}
