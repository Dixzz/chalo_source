package server.zophop.cron;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import java.util.Map;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import server.zophop.models.SimpleLogger;

public class UrlTriggerJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleLogger.debug("Test Trigger");
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        try {
            String string = mergedJobDataMap.getString("url");
            System.out.println(string);
            Map map = null;
            if (mergedJobDataMap.containsKey(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY)) {
                map = (Map) mergedJobDataMap.get(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
            }
            HttpRequest httpRequest = Unirest.get(string);
            if (!(map == null || map.size() == 0)) {
                httpRequest = httpRequest.queryString(map);
            }
            HttpResponse asString = httpRequest.asString();
            if (asString.getStatus() == 200) {
                SimpleLogger.debug(((String) asString.getBody()).toString());
                return;
            }
            throw new JobExecutionException("failed " + asString.getStatus());
        } catch (UnirestException e) {
            SimpleLogger.logException(e);
            throw new JobExecutionException(e);
        }
    }
}
