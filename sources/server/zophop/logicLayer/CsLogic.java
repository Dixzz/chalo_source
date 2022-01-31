package server.zophop.logicLayer;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import server.zophop.CS;
import server.zophop.Constants;
import server.zophop.TaskCategory;
import server.zophop.TaskType;
import server.zophop.dataLayer.Firebase.LiveData;
import server.zophop.dataLayer.Firebase.SessionData;
import server.zophop.dataLayer.Firebase.StaticData;
import server.zophop.dataLayer.Redis.RedisUtils;
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
import server.zophop.queue.BasicTask;
import server.zophop.queue.RabbitMQ;
import server.zophop.utils.DataMapCreator;
import server.zophop.utils.DistanceUtils;
import server.zophop.utils.TimeStampUtils;

public class CsLogic implements ILogic {
    public static final int ETA_FORCE_UPDATE_REDIS_TTL = 180;
    public static final double THRESHOLD_PROXIMITY_DISTANCE = 100.0d;
    private static final Long _timeGap = Long.valueOf((long) Constants.THRESHOLD_TIMESTAMP);
    private RabbitMQ _analysisQueue;
    private DataContainer _container = DataContainer.getDataContainer();
    public HaltDataHandler _haltDataHandler = new HaltDataHandler();
    public RedisUtils _redis = new RedisUtils();
    private CS cs;

    public CsLogic() {
        CS.ENVIRONMENT valueOf = CS.ENVIRONMENT.valueOf("production");
        SimpleLogger.config("startListening cs " + valueOf);
        this.cs = new CS();
        RabbitMQ rabbitMQ = new RabbitMQ(1, Constants.getExchange(), TaskCategory.ANALYTICS);
        this._analysisQueue = rabbitMQ;
        rabbitMQ.init();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01e8 A[SYNTHETIC, Splitter:B:48:0x01e8] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addLastKnownPoint(server.zophop.models.Stream r24, server.zophop.models.RealTimeRouteInfo r25, server.zophop.models.Point r26, server.zophop.models.Route r27, server.zophop.models.StreamMeta r28) {
        /*
        // Method dump skipped, instructions count: 515
        */
        throw new UnsupportedOperationException("Method not decompiled: server.zophop.logicLayer.CsLogic.addLastKnownPoint(server.zophop.models.Stream, server.zophop.models.RealTimeRouteInfo, server.zophop.models.Point, server.zophop.models.Route, server.zophop.models.StreamMeta):void");
    }

    private void addStreamPoint(StreamMeta streamMeta, Point point, Stream stream) {
        StringBuilder i0 = hj1.i0("Processing point for stream :");
        i0.append(stream.getStreamId());
        SimpleLogger.debug(i0.toString());
        Route route = this._container.getRoute(stream.getCity(), stream.getStationType(), stream.getRouteId());
        fillDataInStream(stream, route);
        processStreamPoint(streamMeta, point, stream, route);
        StringBuilder i02 = hj1.i0("Finished processing point for stream :");
        i02.append(stream.getStreamId());
        i02.append("\n");
        SimpleLogger.debug(i02.toString());
    }

    private static long approximateTime(double d, boolean z) {
        double d2;
        double d3;
        if (z) {
            d2 = d * 1000.0d;
            d3 = 5.0d;
        } else {
            d2 = d * 1000.0d;
            d3 = 2.0d;
        }
        return (long) (d2 / d3);
    }

    public static boolean chanceToRecord() {
        return new Random().nextInt(20) == 1;
    }

    private boolean checkForActiveEta(String str, String str2, ETA eta) {
        if (this._redis.containsKey(str2)) {
            JSONObject jSONObject = new JSONObject(this._redis.get(str2));
            if (!jSONObject.getString("_stopId").equalsIgnoreCase(eta.getStopId()) || !jSONObject.getString("_routeName").equalsIgnoreCase(eta.getRouteName()) || !jSONObject.getString("_destination").equalsIgnoreCase(eta._destination)) {
                this._redis.put(str2, eta.toString(), ETA_FORCE_UPDATE_REDIS_TTL);
                return true;
            }
            int abs = Math.abs(jSONObject.getInt("_eta") - eta._eta.intValue());
            if (abs <= 20 && (!str.equalsIgnoreCase("kochi") || abs <= 30)) {
                return false;
            }
            this._redis.put(str2, eta.toString(), ETA_FORCE_UPDATE_REDIS_TTL);
            return true;
        }
        this._redis.put(str2, eta.toString(), ETA_FORCE_UPDATE_REDIS_TTL);
        return true;
    }

    private void checkPointValidation(Stream stream, Point point, Route route, StreamMeta streamMeta, boolean z) {
        StreamStatus timeStatus = stream.getTimeStatus();
        StreamStatus streamStatus = StreamStatus.WAITING;
        if (timeStatus.equals(streamStatus)) {
            setProximityOrTimeStatus(stream, true, StreamStatus.OPEN);
        }
        if (!stream.isVerified()) {
            Stop stop = this._container.getStop(stream.getCity(), stream.getStationType(), stream.getLastStopId());
            Stop stop2 = this._container.getStop(stream.getCity(), stream.getStationType(), stream.getNextStopId());
            double straightDistance = DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), stop.getLat(), stop.getLon());
            double straightDistance2 = DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), stop2.getLat(), stop2.getLon());
            if (straightDistance <= 100.0d || straightDistance2 <= 100.0d) {
                SimpleLogger.debug("In threshold distance");
                if (stream.getProxmityStatus().equals(streamStatus)) {
                    setProximityOrTimeStatus(stream, false, StreamStatus.OPEN);
                }
                if (straightDistance2 <= 100.0d) {
                    processNextStop(stream, route, streamMeta);
                }
                stream.setLastValidStopIdVisitTime(point.getTime());
            } else {
                validteStreamStatus(stream, point, stop2, stop, z);
            }
            if (stream.status().equals(StreamStatus.CLOSED) || stream.status().equals(StreamStatus.TERMINATED)) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x028b, code lost:
        if (r39.equalsIgnoreCase("indore") != false) goto L_0x0273;
     */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<server.zophop.models.Pair<java.lang.String, server.zophop.models.ETA>> computeEtas(java.lang.String r38, java.lang.String r39, server.zophop.models.Point r40, server.zophop.models.Route r41, double r42, server.zophop.models.Stop r44, long r45) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 760
        */
        throw new UnsupportedOperationException("Method not decompiled: server.zophop.logicLayer.CsLogic.computeEtas(java.lang.String, java.lang.String, server.zophop.models.Point, server.zophop.models.Route, double, server.zophop.models.Stop, long):java.util.List");
    }

    private List<Pair<String, ETA>> computeReverseEtas(String str, String str2, Point point, Route route, double d, Stop stop, int i, double d2) {
        CsLogic csLogic = this;
        String str3 = str2;
        ArrayList arrayList = new ArrayList();
        int haltTime = (int) StaticData.getHaltTime(str3, route.getId(), Calendar.getInstance().get(11));
        double avgSpeed = StaticData.getAvgSpeed(str3, route.getId(), Calendar.getInstance().get(11));
        if (avgSpeed <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            avgSpeed = d;
        }
        int i2 = route.getStationType().equalsIgnoreCase("bus") ? 20 : 60;
        long time = point.getTime();
        arrayList.add(new Pair(route.getStopSequence().get(0), new ETA(i, time, route.getName(), route.getLastStop(), str, route.getAgency(), d2)));
        double d3 = d2;
        int i3 = i + haltTime;
        int i4 = 1;
        int i5 = i;
        while (i4 < route.getStopSequence().size()) {
            Stop stop2 = csLogic._container.getStop(str3, route.getStationType(), route.getStopSequence().get(i4 - 1));
            Stop stop3 = csLogic._container.getStop(str3, route.getStationType(), route.getStopSequence().get(i4));
            double straightDistance = DistanceUtils.straightDistance(stop2.getLat(), stop2.getLon(), stop3.getLat(), stop3.getLon());
            int i6 = (int) (straightDistance / avgSpeed);
            i3 = i3 + i6 + i2;
            d3 += straightDistance;
            int i7 = i5 + i6 + i2;
            arrayList.add(new Pair(route.getStopSequence().get(i4), new ETA(i7, i3, time, route.getName(), route.getLastStop(), str, route.getAgency(), d3)));
            i4++;
            csLogic = this;
            str3 = str2;
            i5 = i7;
        }
        return arrayList;
    }

    private void fillDataInStream(Stream stream, Route route) {
        StringBuilder i0 = hj1.i0("inside fill data in stream ");
        i0.append(route.getId());
        SimpleLogger.warning(i0.toString());
        SimpleLogger.warning("stream  " + stream.toString());
        String sourceStopId = stream.getSourceStopId();
        Integer index = route.getIndex(sourceStopId);
        if (index == null) {
            index = 0;
        }
        stream.setLastValidStopIdIndex(index.intValue());
        stream.setLastStopId(sourceStopId);
        stream.setRouteName(route.getName());
        stream.setStationType(route.getStationType());
        stream.setFromStopName(route.getFirstStop());
        stream.setToStopName(route.getLastStop());
    }

    private void getPointDistances(String str, Route route, Point point, HashMap<String, Integer> hashMap) {
        Stop stop = this._container.getStop(str, route.getStationType(), route.getStopSequence().get(0));
        Stop stop2 = this._container.getStop(str, route.getStationType(), route.getStopSequence().get(1));
        int straightDistance = (int) DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), stop.getLat(), stop.getLon());
        int straightDistance2 = (int) DistanceUtils.straightDistance(point.getLatitude(), point.getLongitude(), stop2.getLat(), stop2.getLon());
        hashMap.put("distanceFromTerminalStop", Integer.valueOf(straightDistance));
        hashMap.put("distanceFromFirstStop", Integer.valueOf(straightDistance2));
        hashMap.put("firstStopDistance", Integer.valueOf((int) DistanceUtils.straightDistance(stop2.getLat(), stop2.getLon(), stop.getLat(), stop.getLon())));
    }

    private boolean isAtTerminalStop(String str, Route route, Point point, int i) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        getPointDistances(str, route, point, hashMap);
        return hashMap.get("distanceFromTerminalStop").intValue() <= 100 || (hashMap.get("distanceFromTerminalStop").intValue() < hashMap.get("distanceFromFirstStop").intValue() && i < 2);
    }

    private boolean isTripStarted(String str, Route route, Point point, double d, int i) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        getPointDistances(str, route, point, hashMap);
        boolean z = !isValidRoute(str, route) || (hashMap.get("distanceFromTerminalStop").intValue() > 100 && (hashMap.get("distanceFromFirstStop").intValue() < hashMap.get("firstStopDistance").intValue() || hashMap.get("distanceFromFirstStop").intValue() < hashMap.get("distanceFromTerminalStop").intValue()));
        if (i < 2 && d < 2.0d && isValidRoute(str, route)) {
            return false;
        }
        if (i >= 2) {
            return true;
        }
        return z;
    }

    private boolean isValidRoute(String str, Route route) {
        return str.equalsIgnoreCase("indore") || str.equalsIgnoreCase("kochi");
    }

    private void processNextStop(Stream stream, Route route, StreamMeta streamMeta) {
        int nextStopIndex = route.getNextStopIndex(stream.getLastStopId(), stream.getNextStopId());
        if (nextStopIndex == route.getStopSequence().size()) {
            setProximityOrTimeStatus(stream, false, StreamStatus.CLOSED);
            return;
        }
        Stop stop = this._container.getStop(stream.getCity(), stream.getStationType(), route.getStopSequence().get(nextStopIndex));
        Stop stop2 = this._container.getStop(stream.getCity(), stream.getStationType(), stream.getNextStopId());
        stream.setNextStopId(stop.getId());
        stream.setLastStopId(stop2.getId());
        stream.setLastValidStopIdIndex(nextStopIndex);
        streamMeta.setStopId(stop.getId());
        streamMeta.setPrevStopId(stop2.getId());
    }

    private void processStreamPoint(StreamMeta streamMeta, Point point, Stream stream, Route route) {
        stream.getStationType().equalsIgnoreCase("bus");
        addLastKnownPoint(stream, new RealTimeRouteInfo(stream.getRouteId(), route.getName(), route.getFirstStop(), route.getLastStop(), route.getStationType(), stream.getAgency(), stream.getUserId()), point, route, streamMeta);
    }

    private void recordEtaPrediction(Stream stream, Point point, Route route, Stop stop, List<Pair<String, ETA>> list) {
        Stop stop2 = null;
        B b = null;
        int i = 0;
        for (int i2 = 0; i2 < route.getStopSequence().size(); i2++) {
            if (list.get(i2).second._eta.intValue() != -1) {
                if (list.get(i2).first.equalsIgnoreCase(stream.getNextStopId())) {
                    Stop stop3 = this._container.getStop(stream.getCity(), route.getStationType(), list.get(i2).first);
                    B b2 = list.get(i2).second;
                    Map etaPredictionMap = DataMapCreator.getEtaPredictionMap(point, stream, route, stop3, b2, i2, stop3, b2, i2);
                    System.out.println(etaPredictionMap.toString());
                    this._analysisQueue.addTask(new BasicTask(stream.getUserId(), TaskType.ETA_PREDICTION, etaPredictionMap));
                    b = b2;
                    stop2 = stop3;
                    i = i2;
                } else {
                    Map etaPredictionMap2 = DataMapCreator.getEtaPredictionMap(point, stream, route, stop2, b, i, this._container.getStop(stream.getCity(), route.getStationType(), list.get(i2).first), list.get(i2).second, i2);
                    System.out.println(etaPredictionMap2.toString());
                    this._analysisQueue.addTask(new BasicTask(stream.getUserId(), TaskType.ETA_PREDICTION, etaPredictionMap2));
                }
            }
        }
    }

    public static void setProximityOrTimeStatus(Stream stream, boolean z, StreamStatus streamStatus) {
        if (z) {
            StringBuilder i0 = hj1.i0("Stream :");
            i0.append(stream.getStreamId());
            i0.append(", Changing time status to : + ");
            i0.append(streamStatus.toString());
            i0.append("\n");
            SimpleLogger.debug(i0.toString());
            stream.setTimeStatus(new AtomicReference<>(streamStatus));
        } else {
            StringBuilder i02 = hj1.i0("Stream :");
            i02.append(stream.getStreamId());
            i02.append(", Changing proximity status to : + ");
            i02.append(streamStatus.toString());
            i02.append("\n");
            SimpleLogger.debug(i02.toString());
            stream.setProximityStatus(streamStatus);
        }
        StreamStatus proxmityStatus = stream.getProxmityStatus();
        StreamStatus streamStatus2 = StreamStatus.OPEN;
        if (!proxmityStatus.equals(streamStatus2) || !stream.getTimeStatus().equals(streamStatus2)) {
            StreamStatus proxmityStatus2 = stream.getProxmityStatus();
            StreamStatus streamStatus3 = StreamStatus.TERMINATED;
            if (proxmityStatus2.equals(streamStatus3) || stream.getTimeStatus().equals(streamStatus3)) {
                CS.pushChangeStatusTask(stream, streamStatus3);
                return;
            }
            StreamStatus proxmityStatus3 = stream.getProxmityStatus();
            StreamStatus streamStatus4 = StreamStatus.CLOSED;
            if (proxmityStatus3.equals(streamStatus4) || stream.getTimeStatus().equals(streamStatus4)) {
                CS.pushChangeStatusTask(stream, streamStatus4);
                return;
            }
            StreamStatus proxmityStatus4 = stream.getProxmityStatus();
            StreamStatus streamStatus5 = StreamStatus.WAITING;
            if (proxmityStatus4.equals(streamStatus5) || stream.getTimeStatus().equals(streamStatus5)) {
                CS.pushChangeStatusTask(stream, streamStatus5);
                return;
            }
            return;
        }
        CS.pushChangeStatusTask(stream, streamStatus2);
    }

    private void validteStreamStatus(Stream stream, Point point, Stop stop, Stop stop2, boolean z) {
        double straightDistance = DistanceUtils.straightDistance(stop.getLat(), stop.getLon(), stop2.getLat(), stop2.getLon());
        stream.setCurrentLegTime(approximateTime(straightDistance, !z));
        stream.setCurrentLegDistance(straightDistance);
        SimpleLogger.debug("Stream :" + stream.getStreamId() + " , point received time :" + point.getTime() + " , Last stop visit time:" + stream.getLastValidStopIdVisitTime() + " , time diff:" + (point.getTime() - stream.getLastValidStopIdVisitTime()) + ", leg time:" + stream.getCurrentLegTime());
        if (point.getTime() > stream.getCurrentLegTime() + stream.getLastValidStopIdVisitTime() && stream.getProxmityStatus().equals(StreamStatus.OPEN)) {
            setProximityOrTimeStatus(stream, false, StreamStatus.WAITING);
        }
        if (point.getTime() > (stream.getCurrentLegTime() * 2) + stream.getLastValidStopIdVisitTime() && stream.getProxmityStatus().equals(StreamStatus.WAITING)) {
            setProximityOrTimeStatus(stream, false, StreamStatus.CLOSED);
        }
        if (point.getTime() > (stream.getCurrentLegTime() * 3) + stream.getLastValidStopIdVisitTime() && stream.getProxmityStatus().equals(StreamStatus.CLOSED)) {
            setProximityOrTimeStatus(stream, false, StreamStatus.TERMINATED);
        }
    }

    @Override // server.zophop.logicLayer.ILogic
    public Stream addMeta(String str, Point point, StreamMeta streamMeta, String str2, String str3) {
        SimpleLogger.info("Received point for stream :" + str + "\n");
        Stream stream = SessionData.getStream(str, str2);
        if (stream == null) {
            System.out.println("stream is null ");
            return stream;
        }
        if (stream.getNextStopId() == null || !stream.getNextStopId().equals(streamMeta.getPrevStopId())) {
            stream.setArrivedAtStop(false);
        } else {
            stream.setArrivedAtStop(true);
        }
        stream.setNextStopId(streamMeta.getStopId());
        stream.setLastStopId(streamMeta.getPrevStopId());
        if (!stream.status().equals(StreamStatus.CLOSED) && !stream.status().equals(StreamStatus.TERMINATED) && !TimeStampUtils.isPointExpired(stream, point)) {
            System.out.println("adde stream point");
            addStreamPoint(streamMeta, point, stream);
        }
        return stream;
    }

    @Override // server.zophop.logicLayer.ILogic
    public void addPoint(String str, Point point, String str2) {
        SimpleLogger.info("point for stream: " + str + " received");
        LiveData.storePoint(str, point, str2);
    }

    @Override // server.zophop.logicLayer.ILogic
    public void addStream(Stream stream) {
        StringBuilder i0 = hj1.i0("stream added with id ");
        i0.append(stream.getStreamId());
        i0.append(" for routeId ");
        i0.append(stream.getRouteId());
        SimpleLogger.info(i0.toString());
        Route route = getRoute(stream.getCity(), stream.getStationType(), stream.getRouteId());
        fillDataInStream(stream, route);
        SessionData.storeStream(stream, route);
    }

    public void changeStreamDestination(String str, String str2, long j, String str3) {
        SimpleLogger.debug("Received changeStreamDestination for stream :" + str + "\n");
        Stream stream = SessionData.getStream(str, str3);
        if (stream != null) {
            stream.setDestinationStopId(str2);
            if (!stream.status().equals(StreamStatus.CLOSED) && !stream.status().equals(StreamStatus.TERMINATED)) {
                SessionData.changeStreamDestinationStop(str, str2, j, stream.getCity());
            }
        }
    }

    @Override // server.zophop.logicLayer.ILogic
    public void changeStreamStatus(String str, StreamStatus streamStatus, String str2) {
        if (streamStatus.equals(StreamStatus.CLOSED) || streamStatus.equals(StreamStatus.TERMINATED)) {
            SimpleLogger.debug(str + " stream closed by client");
            removeStream(str, str2);
            return;
        }
        SessionData.storeStreamStatus(str, streamStatus.name(), str2, "statusChanged");
    }

    public DataContainer getContainer() {
        return this._container;
    }

    public Route getRoute(String str, String str2, String str3) {
        return this._container.getRoute(str, str2, str3);
    }

    @Override // server.zophop.logicLayer.ILogic
    public void removeStream(String str, String str2) {
        SessionData.storeStreamStatus(str, StreamStatus.CLOSED.name(), str2, "removeStream");
        if (!this._redis.remove(str)) {
            SimpleLogger.info("Failed to remove session id:" + str);
        }
        if (!this._redis.removeFromSet(str2.toLowerCase(), str)) {
            StringBuilder i0 = hj1.i0("Failed to remove session from set, city:");
            i0.append(str2.toLowerCase());
            i0.append(", id:");
            i0.append(str);
            SimpleLogger.info(i0.toString());
        }
        SimpleLogger.info("stream removed with id " + str);
        Stream stream = SessionData.getStream(str, str2);
        if (stream != null) {
            StringBuilder l0 = hj1.l0("stream removed with id ", str, " with routeId ");
            l0.append(stream.getRouteId());
            SimpleLogger.info(l0.toString());
            fillDataInStream(stream, this._container.getRoute(stream.getCity(), stream.getStationType(), stream.getRouteId()));
            CS.removeProximityAndETA(stream);
        }
    }

    public Route routeMatch(String str, String str2, String str3, String str4) {
        return new FuzzyRouteMatcher().match(str3, str4, this._container.getAllBusRoutes(str, str2));
    }
}
