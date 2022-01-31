package server.zophop.cron;

import com.firebase.client.Firebase;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import server.zophop.queue.TaskFailureHandler;

public class ZophopJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        new TaskFailureHandler(new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production")).execute();
    }
}
