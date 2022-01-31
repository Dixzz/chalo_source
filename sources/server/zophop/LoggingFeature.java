package server.zophop;

import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import com.rabbitmq.client.AMQP;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import server.zophop.logging.ElasticHandler;
import server.zophop.logging.LoggingConstants;
import server.zophop.logging.LoggingLogic;
import server.zophop.models.HTTPResponse;
import server.zophop.models.SimpleLogger;
import server.zophop.queue.BasicTask;
import server.zophop.queue.IQueueConsumer;
import server.zophop.queue.ITaskHandler;
import server.zophop.queue.RabbitMQ;
import server.zophop.queue.TaskMeta;
import server.zophop.utils.HttpUtils;
import server.zophop.utils.RouteMappingUtils;

public class LoggingFeature implements ITaskHandler {
    private ElasticHandler _elasticHandler;
    private LoggingLogic _loggingLogic;
    private RabbitMQ _rabbitMQLogger;
    private RabbitMQ _rabbitMQLogger1;

    public LoggingFeature(ElasticHandler elasticHandler, LoggingLogic loggingLogic) {
        this._elasticHandler = elasticHandler;
        this._loggingLogic = loggingLogic;
        RabbitMQ rabbitMQ = new RabbitMQ(1, Constants.getExchange(), TaskCategory.EXCEPTION);
        this._rabbitMQLogger = rabbitMQ;
        rabbitMQ.init();
        RabbitMQ rabbitMQ2 = new RabbitMQ(1, Constants.getExchange(), TaskCategory.REQUEUE);
        this._rabbitMQLogger1 = rabbitMQ2;
        rabbitMQ2.init();
    }

    private void forwardData(TaskType taskType, JSONObject jSONObject) {
        if (RouteMappingUtils.containsVehicleNo(jSONObject.getString(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO))) {
            HashMap m0 = hj1.m0("api_key", "iSpl#^$#^123");
            if (taskType.equals(TaskType.DISPATCH)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, jSONObject.getString(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO));
                jSONObject2.put("deviceId", RouteMappingUtils.getDeviceId(jSONObject.getString(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO)));
                jSONObject2.put("timeStamp", jSONObject.getLong("timeStamp"));
                jSONObject2.put("checkIn", jSONObject.getBoolean("checkIn"));
                if (jSONObject.getBoolean("checkIn")) {
                    jSONObject2.put("routeName", jSONObject.getString("routeName"));
                    jSONObject2.put(LoggingConstants.ROUTE_ID, jSONObject.getString(LoggingConstants.ROUTE_ID));
                    jSONObject2.put(Constants.END_STOP_STOP_NAME, jSONObject.getString(Constants.END_STOP_STOP_NAME));
                    jSONObject2.put(Constants.START_STOP_NAME, jSONObject.getString(Constants.START_STOP_NAME));
                }
                try {
                    System.out.println(jSONObject2.toString());
                    HTTPResponse postWithHeaders = HttpUtils.postWithHeaders("http://aictslchalo.infinium.management/api/Device/DispatchPacket", m0, jSONObject2.toString());
                    if (postWithHeaders != null) {
                        PrintStream printStream = System.out;
                        printStream.println("resposne code " + postWithHeaders.code());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (taskType.equals(TaskType.GPS_POINT_TEST)) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, jSONObject.getString(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO));
                jSONObject3.put("deviceId", jSONObject.getString("deviceId"));
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("timeStamp", jSONObject.getJSONObject("point").getLong("timeStamp"));
                jSONObject4.put(Constants.LATITUDE, jSONObject.getJSONObject("point").getDouble(Constants.LATITUDE));
                jSONObject4.put(Constants.LONGITUDE, jSONObject.getJSONObject("point").getDouble(Constants.LONGITUDE));
                jSONObject4.put("pointSpeed", jSONObject.getJSONObject("point").getDouble("pointSpeed"));
                jSONObject3.put("point", jSONObject4);
                try {
                    HTTPResponse postWithHeaders2 = HttpUtils.postWithHeaders("http://aictslchalo.infinium.management/api/Device/VehicleTrackData", m0, new JSONArray().put(jSONObject3).toString());
                    if (postWithHeaders2 != null) {
                        PrintStream printStream2 = System.out;
                        printStream2.println("response code " + postWithHeaders2.code());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private String hackIndex(TaskType taskType, HashMap<String, Object> hashMap, JSONObject jSONObject, String str) {
        if (hashMap.containsKey("source") && ((String) hashMap.get("source")).equals("cstcIdeation")) {
            str = "ideation";
        }
        if (taskType.equals(TaskType.DISPATCH)) {
            return hj1.S("dispatch_", str);
        }
        if (!taskType.equals(TaskType.GPS_POINT_TEST)) {
            return str;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("lat", ((Map) hashMap.get("point")).get(Constants.LATITUDE));
        jSONObject2.put("lon", ((Map) hashMap.get("point")).get(Constants.LONGITUDE));
        jSONObject.put("geoPoint", jSONObject2);
        return "gps_" + str;
    }

    private void handleExcetion(IQueueConsumer iQueueConsumer, BasicTask basicTask, TaskMeta taskMeta, Exception exc) {
        requeueError(basicTask);
        iQueueConsumer.taskFailure(taskMeta, basicTask);
        SimpleLogger.logException(exc);
    }

    private void requeue(BasicTask basicTask) {
        this._rabbitMQLogger1.addTask(new BasicTask(basicTask.getUserId(), basicTask.getType(), basicTask.getData()));
    }

    private void requeueError(BasicTask basicTask) {
        this._rabbitMQLogger.addTask(new BasicTask(basicTask.getUserId(), basicTask.getType(), basicTask.getData()));
    }

    private void taskResponse(IQueueConsumer iQueueConsumer, BasicTask basicTask, TaskMeta taskMeta, int i) {
        if (i >= 200 && i < 300) {
            iQueueConsumer.taskSuccess(taskMeta, basicTask);
        } else if (i == 429 || i == 502) {
            requeue(basicTask);
            iQueueConsumer.taskFailure(taskMeta, basicTask);
        } else {
            requeueError(basicTask);
            iQueueConsumer.taskFailure(taskMeta, basicTask);
        }
    }

    @Override // server.zophop.queue.ITaskHandler
    public void taskReceived(IQueueConsumer iQueueConsumer, BasicTask basicTask, TaskMeta taskMeta) {
        TaskType type = basicTask.getType();
        if (type.equals(TaskType.GPS_POINT_TEST) || type.equals(TaskType.DISPATCH) || type.equals(TaskType.LOGGING)) {
            StringBuilder i0 = hj1.i0(" task name :");
            i0.append(type.name());
            SimpleLogger.info(i0.toString());
            try {
                HashMap<String, Object> hashMap = (HashMap) basicTask.getData();
                JSONObject jSONObject = new JSONObject(hashMap);
                int execute = this._elasticHandler.execute(jSONObject, hackIndex(type, hashMap, jSONObject, ((String) hashMap.get("agency")).replaceAll(" ", "")), type.toString());
                forwardData(type, jSONObject);
                taskResponse(iQueueConsumer, basicTask, taskMeta, execute);
            } catch (Exception e) {
                handleExcetion(iQueueConsumer, basicTask, taskMeta, e);
            }
        } else if (type.equals(TaskType.POINT_ADDED)) {
            StringBuilder i02 = hj1.i0(" task name :");
            i02.append(type.name());
            SimpleLogger.info(i02.toString());
            try {
                HashMap hashMap2 = (HashMap) basicTask.getData();
                JSONObject jSONObject2 = new JSONObject(hashMap2);
                HashMap hashMap3 = (HashMap) hashMap2.get("point");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("lat", hashMap3.get(Constants.LATITUDE));
                jSONObject3.put("lon", hashMap3.get(Constants.LONGITUDE));
                jSONObject2.put("geoPoint", jSONObject3);
                int execute2 = this._elasticHandler.execute(jSONObject2, type.toString(), "type");
                ElasticHandler elasticHandler = this._elasticHandler;
                elasticHandler.execute(jSONObject2, type.toString() + "2", "type");
                taskResponse(iQueueConsumer, basicTask, taskMeta, execute2);
            } catch (Exception e2) {
                handleExcetion(iQueueConsumer, basicTask, taskMeta, e2);
            }
        } else {
            boolean equals = type.equals(TaskType.TRIP_END);
            int i = AMQP.REPLY_SUCCESS;
            if (equals && basicTask.getData().get(LoggingConstants.STREAM_STATUS).equals(LoggingConstants.CLOSED)) {
                StringBuilder i03 = hj1.i0("task name : ");
                i03.append(type.name());
                SimpleLogger.info(i03.toString());
                try {
                    Map sessionData = this._loggingLogic.getSessionData(basicTask.getData());
                    if (!sessionData.get("source").equals(LoggingConstants.CONDUCTOR)) {
                        i = this._elasticHandler.execute(new JSONObject(sessionData), LoggingConstants.SESSION, "type");
                    }
                    taskResponse(iQueueConsumer, basicTask, taskMeta, i);
                } catch (Exception e3) {
                    handleExcetion(iQueueConsumer, basicTask, taskMeta, e3);
                }
            } else if (type.equals(TaskType.STREAM_ADDED) || type.equals(TaskType.STATUS_CHANGED)) {
                StringBuilder i04 = hj1.i0(" task name :");
                i04.append(type.name());
                SimpleLogger.info(i04.toString());
                try {
                    HashMap hashMap4 = (HashMap) basicTask.getData();
                    hashMap4.put("userId", basicTask.getUserId());
                    taskResponse(iQueueConsumer, basicTask, taskMeta, this._elasticHandler.execute(new JSONObject(hashMap4), type.toString(), "type"));
                } catch (Exception e4) {
                    handleExcetion(iQueueConsumer, basicTask, taskMeta, e4);
                }
            } else if (type.equals(TaskType.TICKET)) {
                StringBuilder i05 = hj1.i0(" task name :");
                i05.append(type.name());
                SimpleLogger.info(i05.toString());
                try {
                    HashMap hashMap5 = (HashMap) basicTask.getData();
                    hashMap5.put("userId", basicTask.getUserId());
                    taskResponse(iQueueConsumer, basicTask, taskMeta, this._elasticHandler.execute(new JSONObject(hashMap5), type.toString(), "type"));
                } catch (Exception e5) {
                    handleExcetion(iQueueConsumer, basicTask, taskMeta, e5);
                }
            } else if (type.equals(TaskType.ROUTE_DEVIATION)) {
                StringBuilder i06 = hj1.i0(" task name :");
                i06.append(type.name());
                SimpleLogger.info(i06.toString());
                try {
                    taskResponse(iQueueConsumer, basicTask, taskMeta, this._elasticHandler.execute(new JSONObject((HashMap) basicTask.getData()), type.toString(), type.toString()));
                } catch (Exception e6) {
                    handleExcetion(iQueueConsumer, basicTask, taskMeta, e6);
                }
            } else if (type.equals(TaskType.SSL_ERROR)) {
                StringBuilder i07 = hj1.i0(" task name :");
                i07.append(type.name());
                SimpleLogger.info(i07.toString());
                try {
                    HashMap hashMap6 = (HashMap) basicTask.getData();
                    hashMap6.put("userId", basicTask.getUserId());
                    taskResponse(iQueueConsumer, basicTask, taskMeta, this._elasticHandler.execute(new JSONObject(hashMap6), type.toString(), "type"));
                } catch (Exception e7) {
                    handleExcetion(iQueueConsumer, basicTask, taskMeta, e7);
                }
            } else if (type.equals(TaskType.GEOFIRE_CRON)) {
                StringBuilder i08 = hj1.i0(" task name :");
                i08.append(type.name());
                SimpleLogger.info(i08.toString());
                try {
                    taskResponse(iQueueConsumer, basicTask, taskMeta, this._elasticHandler.execute(new JSONObject((HashMap) basicTask.getData()), type.toString(), "type"));
                } catch (Exception e8) {
                    handleExcetion(iQueueConsumer, basicTask, taskMeta, e8);
                }
            } else if (type.equals(TaskType.RABBIT_HTTP)) {
                StringBuilder i09 = hj1.i0(" task name :");
                i09.append(type.name());
                SimpleLogger.info(i09.toString());
                try {
                    taskResponse(iQueueConsumer, basicTask, taskMeta, this._elasticHandler.execute(new JSONObject((HashMap) basicTask.getData()), type.toString(), "type"));
                } catch (Exception e9) {
                    handleExcetion(iQueueConsumer, basicTask, taskMeta, e9);
                }
            } else if (type.equals(TaskType.DISPATCH_USER_INFO)) {
                StringBuilder i010 = hj1.i0(" task name :");
                i010.append(type.name());
                SimpleLogger.info(i010.toString());
                try {
                    taskResponse(iQueueConsumer, basicTask, taskMeta, this._elasticHandler.execute(new JSONObject((HashMap) basicTask.getData()), type.toString(), "type"));
                } catch (Exception e10) {
                    handleExcetion(iQueueConsumer, basicTask, taskMeta, e10);
                }
            } else if (type.equals(TaskType.SYSTEM_DELAY)) {
                StringBuilder i011 = hj1.i0(" task name :");
                i011.append(type.name());
                SimpleLogger.info(i011.toString());
                try {
                    taskResponse(iQueueConsumer, basicTask, taskMeta, this._elasticHandler.execute(new JSONObject((HashMap) basicTask.getData()), type.toString(), "type"));
                } catch (Exception e11) {
                    handleExcetion(iQueueConsumer, basicTask, taskMeta, e11);
                }
            } else if (type.equals(TaskType.GPS_DISTANCE)) {
                StringBuilder i012 = hj1.i0(" task name :");
                i012.append(type.name());
                SimpleLogger.info(i012.toString());
                try {
                    taskResponse(iQueueConsumer, basicTask, taskMeta, this._elasticHandler.execute(new JSONObject((HashMap) basicTask.getData()), "gpsbaseddistance", "type"));
                } catch (Exception e12) {
                    handleExcetion(iQueueConsumer, basicTask, taskMeta, e12);
                }
            } else if (type.equals(TaskType.ETA) || type.equals(TaskType.TRIP) || type.equals(TaskType.ROUTE_PREDICTION)) {
                StringBuilder i013 = hj1.i0(" task name :");
                i013.append(type.name());
                SimpleLogger.info(i013.toString());
                try {
                    taskResponse(iQueueConsumer, basicTask, taskMeta, this._elasticHandler.execute(new JSONObject((HashMap) basicTask.getData()), type.toString(), "type"));
                } catch (Exception e13) {
                    handleExcetion(iQueueConsumer, basicTask, taskMeta, e13);
                }
            } else if (type.equals(TaskType.STOP_ARRIVAL)) {
                StringBuilder i014 = hj1.i0(" task name :");
                i014.append(type.name());
                SimpleLogger.info(i014.toString());
                try {
                    for (Map map : (List) ((HashMap) basicTask.getData()).get("stops")) {
                        JSONObject jSONObject4 = new JSONObject(map);
                        System.out.println(jSONObject4.toString());
                        i = this._elasticHandler.execute(jSONObject4, type.toString(), "type");
                        System.out.println();
                    }
                    taskResponse(iQueueConsumer, basicTask, taskMeta, i);
                } catch (Exception e14) {
                    handleExcetion(iQueueConsumer, basicTask, taskMeta, e14);
                }
            } else {
                iQueueConsumer.taskSuccess(taskMeta, basicTask);
            }
        }
    }
}
