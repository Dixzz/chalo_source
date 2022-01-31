package server.zophop;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import server.zophop.analytics.PostgresHandler;
import server.zophop.analytics.SQL;
import server.zophop.analytics.Utils;
import server.zophop.models.SimpleLogger;
import server.zophop.queue.BasicTask;
import server.zophop.queue.IQueueConsumer;
import server.zophop.queue.ITaskHandler;
import server.zophop.queue.TaskMeta;

public class AnalyticsFeature implements ITaskHandler {
    private MobileTicketing _mobileTicketing = new MobileTicketing();
    private PostgresHandler _postgresHandler;

    public AnalyticsFeature(PostgresHandler postgresHandler) {
        this._postgresHandler = postgresHandler;
    }

    @Override // server.zophop.queue.ITaskHandler
    public void taskReceived(IQueueConsumer iQueueConsumer, BasicTask basicTask, TaskMeta taskMeta) {
        TaskType type = basicTask.getType();
        if (type.equals(TaskType.STOP_ARRIVAL)) {
            List<Map> list = (List) ((HashMap) basicTask.getData()).get("stops");
            String str = null;
            for (Map map : list) {
                JSONObject jSONObject = new JSONObject(map);
                System.out.println(jSONObject.toString());
                String fetchEtaAccuracyData = SQL.fetchEtaAccuracyData(jSONObject);
                System.out.println(fetchEtaAccuracyData);
                str = Utils.matchEtaPredictionAndStopArrival(jSONObject, this._postgresHandler.fetcher(fetchEtaAccuracyData));
                if (str != null) {
                    break;
                }
            }
            if (str != null) {
                for (Map map2 : list) {
                    int updateEtaAccuracyData = this._postgresHandler.updateEtaAccuracyData(SQL.updateEtaAccuracyData(new JSONObject(map2), str));
                    PrintStream printStream = System.out;
                    StringBuilder i0 = hj1.i0("no of updates for stop ");
                    i0.append(map2.get("stopName"));
                    i0.append(" = ");
                    i0.append(updateEtaAccuracyData);
                    printStream.println(i0.toString());
                }
            }
            iQueueConsumer.taskSuccess(taskMeta, basicTask);
        } else if (type.equals(TaskType.ETA_PREDICTION)) {
            HashMap hashMap = (HashMap) basicTask.getData();
            String etaAccuracyQuery = SQL.getEtaAccuracyQuery(hashMap);
            System.out.println(etaAccuracyQuery);
            this._postgresHandler.addData(etaAccuracyQuery);
            if (this._postgresHandler.addData(SQL.getETAQuery(hashMap))) {
                iQueueConsumer.taskSuccess(taskMeta, basicTask);
            } else {
                iQueueConsumer.taskFailure(taskMeta, basicTask);
            }
        }
        if (type.equals(TaskType.PUNCH_MPASS)) {
            try {
                SimpleLogger.info("task: " + type.name());
                basicTask.getData().put("userId", basicTask.getUserId());
                if (this._mobileTicketing.postData(basicTask.getData(), Constants.getPunchMpassEndpoint())) {
                    iQueueConsumer.taskSuccess(taskMeta, basicTask);
                } else {
                    iQueueConsumer.taskFailure(taskMeta, basicTask);
                }
            } catch (Exception e) {
                SimpleLogger.logException(e);
                iQueueConsumer.taskFailure(taskMeta, basicTask);
            }
        }
        if (type.equals(TaskType.PUNCH_PASS)) {
            try {
                SimpleLogger.info("task: " + type.name());
                if (this._mobileTicketing.postData(basicTask.getData(), Constants.getPunchPassEndpoint())) {
                    iQueueConsumer.taskSuccess(taskMeta, basicTask);
                } else {
                    iQueueConsumer.taskFailure(taskMeta, basicTask);
                }
            } catch (Exception e2) {
                SimpleLogger.logException(e2);
                iQueueConsumer.taskFailure(taskMeta, basicTask);
            }
        }
        if (type.equals(TaskType.TICKET)) {
            try {
                SimpleLogger.info("task: " + type.name());
                basicTask.getData().put("userId", basicTask.getUserId());
                if (this._mobileTicketing.postData(basicTask.getData(), Constants.getPunchPassEndpoint())) {
                    iQueueConsumer.taskSuccess(taskMeta, basicTask);
                } else {
                    iQueueConsumer.taskFailure(taskMeta, basicTask);
                }
            } catch (Exception e3) {
                SimpleLogger.logException(e3);
                iQueueConsumer.taskFailure(taskMeta, basicTask);
            }
        }
    }
}
