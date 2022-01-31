package server.zophop.gpsIntegration;

import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import java.util.HashMap;
import java.util.Map;
import server.zophop.Constants;
import server.zophop.TaskCategory;
import server.zophop.TaskType;
import server.zophop.gpsIntegration.models.VehicleCheckinInfo;
import server.zophop.logging.LoggingConstants;
import server.zophop.models.CheckOutType;
import server.zophop.models.HaltState;
import server.zophop.models.HaltStatus;
import server.zophop.models.Meta;
import server.zophop.models.Point;
import server.zophop.models.Route;
import server.zophop.models.Stream;
import server.zophop.models.StreamStatus;
import server.zophop.queue.BasicTask;
import server.zophop.queue.IQueue;
import server.zophop.queue.RabbitMQ;
import server.zophop.utils.DataMapCreator;

public class EventHandler {
    private DataMapCreator _mapCreator = new DataMapCreator();
    private IQueue _queue;
    private RabbitMQ _rabbitMQLogger;

    public EventHandler(IQueue iQueue) {
        this._queue = iQueue;
        RabbitMQ rabbitMQ = new RabbitMQ(1, Constants.getExchange(), TaskCategory.LOGGING);
        this._rabbitMQLogger = rabbitMQ;
        rabbitMQ.init();
    }

    public void addWrongDispatchingTask(Map map) {
        this._rabbitMQLogger.addTask(TaskCategory.LOGGING, new BasicTask("wrong_dispatch", TaskType.WRONG_DISPATCH, map));
    }

    public void fireAddAutoRouteDeviationCheckIn(String str, String str2, String str3, String str4, String str5, boolean z, long j, String str6, Point point, String str7, String str8, String str9) {
        this._queue.addTask(TaskCategory.LOGGING, new BasicTask(str6, TaskType.NON_LIVE_POINTS, this._mapCreator.autoRouteDeviationMap(str, str2, str3, str4, str5, z, j, str6, point, str7, str8, str9)));
    }

    public void fireAddPointTask(String str, String str2, Point point, Meta meta, String str3, Route route, String str4, long j, HaltState haltState) {
        HashMap hashMap = new HashMap();
        boolean equals = haltState.getHaltStatus().equals(HaltStatus.SOFT_HALT);
        hashMap.put("nextStopId", meta.getNextStopId());
        hashMap.put("previousStopId", meta.getPreviousStopId());
        hashMap.put(LoggingConstants.SPEED, Double.valueOf(meta.getSpeed()));
        hashMap.put(LoggingConstants.ROUTE_ID, route.getId());
        hashMap.put("halted", Boolean.valueOf(equals));
        hashMap.put("routeName", route.getName());
        hashMap.put("destinationEta", Integer.valueOf(meta.getDestinationEta()));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("point", this._mapCreator.getTaskPointMap(point));
        hashMap2.put("streamId", str2);
        hashMap2.put("city", str4);
        hashMap2.put("agency", str3);
        hashMap2.put("userId", str);
        hashMap2.put("processingTime", Long.valueOf(point.getTime() - System.currentTimeMillis()));
        hashMap2.put("systemTimeStamp", Long.valueOf(j));
        hashMap2.put("logTime", Long.valueOf(System.currentTimeMillis()));
        hashMap2.put("meta", hashMap);
        System.out.println(hashMap2.toString());
        this._queue.addTask(new BasicTask(str, TaskType.POINT_ADDED, hashMap2));
    }

    public void fireCheckInTask(String str, Route route) {
        HashMap hashMap = new HashMap();
        hashMap.put("checkIn", Boolean.TRUE);
        hashMap.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, str);
        hashMap.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        hashMap.put(LoggingConstants.ROUTE_ID, route.getId());
        hashMap.put(Constants.END_STOP_STOP_NAME, route.getLastStop());
        hashMap.put(Constants.START_STOP_NAME, route.getFirstStop());
        hashMap.put("routeName", route.getName());
        this._rabbitMQLogger.addTask(TaskCategory.LOGGING, new BasicTask(str, TaskType.DISPATCH, hashMap));
    }

    public void fireCheckOutTask(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("checkIn", Boolean.FALSE);
        hashMap.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, str);
        hashMap.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        this._rabbitMQLogger.addTask(TaskCategory.LOGGING, new BasicTask(str, TaskType.DISPATCH, hashMap));
    }

    public void fireRouteDeviationCheckoutTask(VehicleCheckinInfo vehicleCheckinInfo, Route route, Point point, int i) {
        this._rabbitMQLogger.addTask(TaskCategory.LOGGING, new BasicTask(vehicleCheckinInfo.getVehicleId(), TaskType.ROUTE_DEVIATION, DataMapCreator.getRouteDeviationCheckoutMap(vehicleCheckinInfo.getVehicleId(), vehicleCheckinInfo.getStreamId(), point, route, i)));
    }

    public void fireStreamAddedTask(String str, Stream stream) {
        this._queue.addTask(new BasicTask(str, TaskType.STREAM_ADDED, this._mapCreator.getTaskStreamMap(str, stream)));
    }

    public void fireStreamRemovedTask(String str, String str2, CheckOutType checkOutType, String str3) {
        this._queue.addTask(new BasicTask(str2, TaskType.STATUS_CHANGED, this._mapCreator.getChangeStreamMap(str, StreamStatus.CLOSED, checkOutType, str3)));
    }
}
