package server.zophop;

import com.rabbitmq.client.ConnectionFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import server.zophop.dataLayer.Firebase.LiveData;
import server.zophop.dataLayer.Firebase.SessionData;
import server.zophop.dataLayer.Firebase.StaticData;
import server.zophop.dataLayer.Firebase.VehicleData;
import server.zophop.models.CheckOutType;
import server.zophop.models.ETA;
import server.zophop.models.Pair;
import server.zophop.models.Point;
import server.zophop.models.RealTimeRouteInfo;
import server.zophop.models.Route;
import server.zophop.models.SimpleLogger;
import server.zophop.models.Stop;
import server.zophop.models.Stream;
import server.zophop.models.StreamMeta;
import server.zophop.models.StreamStatus;
import server.zophop.queue.Task;
import server.zophop.utils.DataMapCreator;

public class CS {
    private static DataMapCreator _dataMapCreator = new DataMapCreator();
    private LiveData liveData = new LiveData();
    private SessionData sessionData = new SessionData();
    private VehicleData vehicleData = new VehicleData();

    public enum ENVIRONMENT {
        production,
        development
    }

    public static Map getEtaMap(Stream stream, Route route, List<Pair<String, ETA>> list) {
        return DataMapCreator.createEtaObject(stream, route, list);
    }

    public static Map<String, Object> getRouteMap(Stream stream, Point point, String str, int i, String str2, boolean z, boolean z2) {
        return DataMapCreator.createRouteObject(stream, point, str, i, str2, z, z2);
    }

    public static Map getSessionsMap(Stream stream, StreamMeta streamMeta, Stop stop, int i, Point point, int i2, boolean z) {
        return DataMapCreator.getStreamMetaMap(stream, streamMeta, stop, i, point.getTime(), stream.getLastValidStopIdVisitTime(), point.getLatitude(), point.getLongitude(), i2, z);
    }

    public static void main(String[] strArr) {
        StaticData.getStops("bhopal", "bus");
    }

    public static void pushChangeStatusTask(Stream stream, StreamStatus streamStatus) {
        StringBuilder i0 = hj1.i0("stream status changed ");
        i0.append(stream.getCity());
        i0.append(" ");
        i0.append(stream.getStreamId());
        i0.append(" ");
        i0.append(streamStatus.name());
        SimpleLogger.info(i0.toString());
        new Task(stream.getUserId(), 0, 0, 0, TaskType.STATUS_CHANGED, _dataMapCreator.getChangeStreamMap(stream.getStreamId(), streamStatus, CheckOutType.proximityOrTimeStatus, stream.getCity()));
    }

    public static void removeProximityAndETA(Stream stream) {
        Route routeFromFirebase = StaticData.getRouteFromFirebase(stream.getCity(), stream.getStationType(), stream.getRouteId());
        RealTimeRouteInfo realTimeRouteInfo = new RealTimeRouteInfo(stream.getRouteId(), stream.getRouteName(), stream.getFromStopName(), stream.getToStopName(), stream.getStationType(), stream.getAgency(), stream.getUserId());
        SimpleLogger.debug("remove _route and geofire");
        LiveData.removeFromRouteIndex(stream.getCity().toUpperCase(), realTimeRouteInfo, stream.getStreamId(), stream.getUserId());
        ArrayList arrayList = new ArrayList();
        for (String str : routeFromFirebase.getStopSequence()) {
            arrayList.add(str);
        }
        StringBuilder i0 = hj1.i0("remove eta for stops ");
        i0.append(arrayList.size());
        SimpleLogger.info(i0.toString());
        removeStreamFromETA(stream.getCity(), stream.getStreamId(), stream.getRouteId(), arrayList);
        if (routeFromFirebase.getReverseRouteId() != null) {
            Route routeFromFirebase2 = StaticData.getRouteFromFirebase(stream.getCity(), stream.getStationType(), routeFromFirebase.getReverseRouteId());
            SimpleLogger.debug("remove _route and geofire");
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : routeFromFirebase2.getStopSequence()) {
                arrayList2.add(str2);
            }
            removeStreamFromETA(stream.getCity(), stream.getStreamId(), routeFromFirebase2.getId(), arrayList2);
        }
    }

    public static void removeStreamFromETA(String str, String str2, String str3, List<String> list) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            StringBuilder i0 = hj1.i0("/eta/");
            i0.append(str.toUpperCase());
            i0.append(ConnectionFactory.DEFAULT_VHOST);
            i0.append(list.get(i));
            i0.append(ConnectionFactory.DEFAULT_VHOST);
            hashMap.put(hj1.b0(i0, str3, ConnectionFactory.DEFAULT_VHOST, str2), null);
        }
        LiveData.storeLiveData(hashMap, str);
    }
}
