package server.zophop.cron;

import com.firebase.client.Firebase;
import com.razorpay.BaseConstants;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import server.zophop.Constants;

public class GeofireCheck implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        new GeofireCron(new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production")).execute();
        new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_SHARD1).child("production")).execute();
        new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_BANGALORE).child("production")).execute();
        new GeofireCron(new Firebase(Constants.LIVE_FIREBASE_SHARD3).child("production")).execute();
        new GeofireCron(new Firebase("https://dazzling-fire-3689.firebaseio.com/").child(BaseConstants.DEVELOPMENT)).execute();
    }
}
