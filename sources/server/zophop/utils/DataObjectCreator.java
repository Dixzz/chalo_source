package server.zophop.utils;

import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import com.firebase.client.DataSnapshot;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.maps.model.LatLng;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import server.zophop.Constants;
import server.zophop.gpsIntegration.models.VehicleCheckinInfo;
import server.zophop.gpsIntegration.models.VehicleGPSInfo;
import server.zophop.logging.LoggingConstants;
import server.zophop.models.Halt;
import server.zophop.models.HaltState;
import server.zophop.models.HaltStatus;
import server.zophop.models.Point;
import server.zophop.models.Route;
import server.zophop.models.SimpleLogger;
import server.zophop.models.Source;
import server.zophop.models.Stop;
import server.zophop.models.Stream;
import server.zophop.models.StreamMeta;
import server.zophop.models.StreamStatus;

public class DataObjectCreator {
    public static Point createPoint(Map map) {
        double parseDouble = Double.parseDouble(map.get(Constants.LATITUDE).toString());
        double parseDouble2 = Double.parseDouble(map.get(Constants.LONGITUDE).toString());
        double parseDouble3 = map.containsKey("pointSpeed") ? Double.parseDouble(map.get("pointSpeed").toString()) : 20.0d;
        long parseLong = Long.parseLong(map.get("timeStamp").toString());
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (map.get("accuracy") != null) {
            d = Double.parseDouble(map.get("accuracy").toString());
        }
        return new Point(parseDouble, parseDouble2, parseLong, parseDouble3, d);
    }

    public static LatLng createPolylinePoint(Map map) {
        double d;
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (map != null) {
            d2 = Double.parseDouble(map.get(Constants.LATITUDE).toString());
            d = Double.parseDouble(map.get(Constants.LONGITUDE).toString());
        } else {
            d = 0.0d;
        }
        return new LatLng(d2, d);
    }

    public static Stream createStream(Map map, String str, String str2) {
        String str3;
        String str4;
        String str5 = (String) map.get("streamId");
        if (map.containsKey("userId")) {
            str3 = (String) map.get("userId");
        } else {
            StringBuilder i0 = hj1.i0(" no userid in datamap for stream :");
            i0.append(map.get("streamId"));
            SimpleLogger.severe(i0.toString());
            str3 = str;
        }
        String str6 = (String) map.get(LoggingConstants.ROUTE_ID);
        String str7 = (String) map.get("mode");
        String str8 = (String) map.get("sourceStopId");
        String str9 = (String) map.get("city");
        String str10 = (String) map.get("destinationStopId");
        String str11 = (String) map.get("routeName");
        boolean booleanValue = ((Boolean) map.get("isVerified")).booleanValue();
        long longValue = ((Number) map.get("timeStamp")).longValue();
        if (map.get("meta") != null) {
            Map map2 = (Map) map.get("meta");
        }
        String str12 = null;
        if (map.containsKey(LoggingConstants.OPERATOR)) {
            str12 = (String) map.get(LoggingConstants.OPERATOR);
        }
        if (map.get("source") != null) {
            str4 = (String) map.get("source");
        } else {
            str4 = Source.defaultCheckIn.toString();
        }
        Stream stream = new Stream(str9, str2, str5, str3, str6, str8, str10, str4, System.currentTimeMillis());
        stream.setStationType(str7);
        stream.setOperator(str12);
        stream.setRouteName(str11);
        stream.setVerified(booleanValue);
        stream.setLastUpdated(longValue);
        stream.setLastValidStopIdVisitTime(longValue);
        stream.setLastEtaUpdated(0);
        return stream;
    }

    public static StreamMeta createStreamMeta(Map map) {
        return new StreamMeta((String) map.get("nextStopId"), (String) map.get("previousStopId"), ((Number) map.get(LoggingConstants.SPEED)).doubleValue(), map.containsKey("halted") ? ((Boolean) map.get("halted")).booleanValue() : false);
    }

    public static Map createSystemDelayMeta(Stream stream, Map map) {
        long parseLong = Long.parseLong(((Map) map.get("point")).get("timeStamp").toString());
        long parseLong2 = Long.parseLong(map.get("systemTimeStamp").toString());
        long parseLong3 = Long.parseLong(map.get("logTime").toString());
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("streamId", stream.getStreamId());
        hashMap.put(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, stream.getUserId());
        hashMap.put("city", stream.getCity());
        hashMap.put("agency", stream.getAgency());
        hashMap.put("systemReceiveTimestamp", Long.valueOf(parseLong2));
        hashMap.put("systemProcessedTimestamp", Double.valueOf((double) currentTimeMillis));
        hashMap.put("pointAddedEventDelay", Double.valueOf(((double) (currentTimeMillis - parseLong3)) / 1000.0d));
        hashMap.put("timeStamp", Long.valueOf(parseLong));
        hashMap.put(LoggingConstants.ROUTE_ID, stream.getRouteId());
        hashMap.put("routeName", stream.getRouteName());
        hashMap.put("nextStopId", stream.getNextStopId());
        hashMap.put("overallDelay", Double.valueOf(((double) (currentTimeMillis - parseLong)) / 1000.0d));
        hashMap.put("systemDelay", Double.valueOf(((double) (currentTimeMillis - parseLong2)) / 1000.0d));
        return hashMap;
    }

    public static VehicleCheckinInfo createVehicleCheckinInfo(String str, String str2, String str3, String str4, Map map) {
        String str5 = (String) map.get("deviceId");
        String str6 = (String) map.get("alias");
        String str7 = null;
        String str8 = map.get(LoggingConstants.ROUTE_ID) == null ? null : (String) map.get(LoggingConstants.ROUTE_ID);
        String str9 = map.get("streamId") == null ? null : (String) map.get("streamId");
        String str10 = map.get("source") == null ? null : (String) map.get("source");
        if (map.get("status") != null) {
            str7 = (String) map.get("status");
        }
        VehicleCheckinInfo vehicleCheckinInfo = new VehicleCheckinInfo(str4, str5, str6, str8, str2, str, str3, str9, str10);
        vehicleCheckinInfo.setStatus(str7);
        return vehicleCheckinInfo;
    }

    public static VehicleGPSInfo createVehicleGPSInfo(String str, String str2, String str3, String str4, Map map) {
        HaltState haltState;
        String str5 = (String) map.get("deviceId");
        String str6 = (String) map.get("alias");
        Point createPoint = createPoint((Map) map.get("lastPoint"));
        double doubleValue = ((Number) map.get(LoggingConstants.SPEED)).doubleValue();
        String str7 = map.get("lastVisitedStopId") == null ? null : (String) map.get("lastVisitedStopId");
        String str8 = map.get("lastVisitedStopName") == null ? null : (String) map.get("lastVisitedStopName");
        int intValue = map.get("deviationCount") == null ? 0 : ((Number) map.get("deviationCount")).intValue();
        int intValue2 = map.get("reversalCount") == null ? 0 : ((Number) map.get("reversalCount")).intValue();
        if (map.containsKey("haltState")) {
            haltState = new HaltState(HaltStatus.valueOf((String) ((Map) map.get("haltState")).get("haltStatus")), createPoint((Map) ((Map) map.get("haltState")).get("haltStartPoint")));
        } else {
            haltState = new HaltState(HaltStatus.NO_HALT, createPoint);
        }
        return new VehicleGPSInfo(str2, str, str3, str4, str5, str6, createPoint, doubleValue, str7, str8, intValue, intValue2, createPolylinePoint((Map) map.get("lastVisitedPolylinePoint")), haltState);
    }

    public static List<Point> extractPoints(DataSnapshot dataSnapshot) {
        ArrayList arrayList = new ArrayList();
        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
            double doubleValue = ((Double) dataSnapshot2.child("accuracy").getValue()).doubleValue();
            arrayList.add(new Point(((Double) dataSnapshot2.child("lat").getValue()).doubleValue(), ((Double) dataSnapshot2.child("lon").getValue()).doubleValue(), ((Long) dataSnapshot2.child("time").getValue()).longValue(), ((Double) dataSnapshot2.child(LoggingConstants.SPEED).getValue()).doubleValue(), doubleValue));
        }
        return arrayList;
    }

    public static Route extractRoute(DataSnapshot dataSnapshot, String str) {
        String str2;
        String str3 = (String) dataSnapshot.child("ag").getValue();
        String str4 = (String) dataSnapshot.child("name").getValue();
        List<String> specialFeature = getSpecialFeature(dataSnapshot.child("sf"));
        ArrayList<String> stopSeq = getStopSeq(dataSnapshot.child("seq"));
        String key = dataSnapshot.getKey();
        String str5 = (String) dataSnapshot.child("f").getValue();
        String str6 = (String) dataSnapshot.child("l").getValue();
        try {
            str2 = (String) dataSnapshot.child("rr").getValue();
        } catch (Exception unused) {
            SimpleLogger.severe("rr value not found for route name : " + str4);
            str2 = null;
        }
        return new Route(key, str4, str5, str6, str3, str, stopSeq, specialFeature, str2, dataSnapshot.hasChild("poly") ? (String) dataSnapshot.child("poly").getValue() : "");
    }

    public static Stop extractStop(DataSnapshot dataSnapshot) {
        return new Stop(dataSnapshot.getKey(), null, (String) dataSnapshot.child("name").getValue(), Double.parseDouble(String.valueOf(dataSnapshot.child("lat").getValue())), Double.parseDouble(String.valueOf(dataSnapshot.child("lon").getValue())));
    }

    public static Stream extractStream(DataSnapshot dataSnapshot) {
        String str;
        boolean z;
        String str2;
        long j;
        try {
            String key = dataSnapshot.getKey();
            String str3 = (String) dataSnapshot.child("city").getValue();
            String str4 = (String) dataSnapshot.child("destinationStopId").getValue();
            String str5 = (String) dataSnapshot.child("nextStopId").getValue();
            String str6 = (String) dataSnapshot.child("previousStopId").getValue();
            String str7 = (String) dataSnapshot.child(LoggingConstants.ROUTE_ID).getValue();
            String str8 = (String) dataSnapshot.child("routeName").getValue();
            String name = StreamStatus.OPEN.name();
            if (dataSnapshot.hasChild("status")) {
                name = (String) dataSnapshot.child("status").getValue();
            }
            String str9 = dataSnapshot.hasChild("agency") ? (String) dataSnapshot.child("agency").getValue() : null;
            String str10 = (String) dataSnapshot.child("stopId").getValue();
            String str11 = (String) dataSnapshot.child("userId").getValue();
            long longValue = dataSnapshot.hasChild("lastUpdated") ? ((Long) dataSnapshot.child("lastUpdated").getValue()).longValue() : System.currentTimeMillis();
            long longValue2 = dataSnapshot.hasChild("lastEtaUpdated") ? ((Long) dataSnapshot.child("lastEtaUpdated").getValue()).longValue() : 0;
            long longValue3 = dataSnapshot.hasChild("lastStopVisitTime") ? ((Long) dataSnapshot.child("lastStopVisitTime").getValue()).longValue() : System.currentTimeMillis();
            long longValue4 = dataSnapshot.hasChild("createdAt") ? ((Long) dataSnapshot.child("createdAt").getValue()).longValue() : System.currentTimeMillis();
            String str12 = (String) dataSnapshot.child("stationType").getValue();
            if (dataSnapshot.child("verified").getValue() == null) {
                str = name;
                z = false;
            } else {
                str = name;
                if (dataSnapshot.child("verified").getValue() instanceof String) {
                    SimpleLogger.debug("point String");
                    z = Boolean.getBoolean((String) dataSnapshot.child("verified").getValue());
                } else {
                    SimpleLogger.debug("point boolean");
                    z = ((Boolean) dataSnapshot.child("verified").getValue()).booleanValue();
                }
            }
            if (dataSnapshot.hasChild("source")) {
                str2 = (String) dataSnapshot.child("source").getValue();
            } else {
                str2 = Source.defaultCheckIn.toString();
            }
            Stream stream = new Stream(str3, str9, key, str11, str7, str10, str4, str2, longValue4);
            if (dataSnapshot.hasChild("nextStopEta")) {
                j = longValue;
                stream.setNextStopEta(((Long) dataSnapshot.child("nextStopEta").getValue()).longValue());
            } else {
                j = longValue;
            }
            if (dataSnapshot.hasChild("cLat")) {
                stream.setClat(((Double) dataSnapshot.child("cLat").getValue()).doubleValue());
            } else {
                stream.setClat(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }
            if (dataSnapshot.hasChild("cLon")) {
                stream.setClon(((Double) dataSnapshot.child("cLon").getValue()).doubleValue());
            } else {
                stream.setClon(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }
            if (dataSnapshot.hasChild(LoggingConstants.OPERATOR)) {
                stream.setOperator((String) dataSnapshot.child(LoggingConstants.OPERATOR).getValue());
            }
            stream.setRouteName(str8);
            stream.setVerified(z);
            stream.setStationType(str12);
            stream.setNextStopId(str5);
            stream.setLastValidStopIdVisitTime(longValue3);
            stream.setLastUpdated(j);
            stream.setLastStopId(str6);
            stream.setProximityStatus(StreamStatus.valueOf(str));
            stream.setTimeStatus(new AtomicReference<>(StreamStatus.valueOf(str)));
            stream.setLastEtaUpdated(longValue2);
            System.out.println("has Halt");
            if (dataSnapshot.hasChild("halt")) {
                stream.setHalt(new Halt(Long.valueOf(((Long) dataSnapshot.child("halt").child(SuperPassJsonKeys.START_TIME).getValue()).longValue()), null, new Point(((Double) dataSnapshot.child("halt").child("startPoint").child("lat").getValue()).doubleValue(), ((Double) dataSnapshot.child("halt").child("startPoint").child("lon").getValue()).doubleValue(), 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), dataSnapshot.child("halt").hasChild("isHaltinDetected") ? ((Boolean) dataSnapshot.child("halt").child("isHaltinDetected").getValue()).booleanValue() : false));
            }
            return stream;
        } catch (Exception unused) {
            SimpleLogger.severe("stream not added.");
            return null;
        }
    }

    private static List<String> getSpecialFeature(DataSnapshot dataSnapshot) {
        if (dataSnapshot == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
            arrayList.add((String) dataSnapshot2.getValue());
        }
        return arrayList;
    }

    private static ArrayList<String> getStopSeq(DataSnapshot dataSnapshot) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
            arrayList.add((String) dataSnapshot2.getValue());
        }
        return arrayList;
    }
}
