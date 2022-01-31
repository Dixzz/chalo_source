package server.zophop.logicLayer;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import server.zophop.Constants;
import server.zophop.dataLayer.Firebase.FirebaseUtils;
import server.zophop.dataLayer.Firebase.StaticData;
import server.zophop.models.Route;
import server.zophop.models.SimpleLogger;
import server.zophop.models.Stop;
import server.zophop.utils.DataObjectCreator;
import server.zophop.utils.RouteMappingUtils;

public class DataContainer {
    private static volatile DataContainer container;
    private Map<String, Map<String, Map<String, Map<String, Map<String, Long>>>>> _etaMap = new HashMap();
    private Map<String, Map<String, Route>> _routeMap = new HashMap();
    private Map<String, Map<String, Stop>> _stopMap = new HashMap();

    private DataContainer() {
    }

    public static DataContainer getDataContainer() {
        if (container == null) {
            container = new DataContainer();
        }
        return container;
    }

    public Map<String, Route> fetchAllRoutes(String str, String str2) {
        if (this._routeMap.containsKey(str)) {
            return this._routeMap.get(str);
        }
        if (str == null || str2 == null) {
            SimpleLogger.debug("route :" + str + " : " + str2);
        }
        DataSnapshot synchronizedDataSnapshot = FirebaseUtils.getSynchronizedDataSnapshot(new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production").child(Constants.CITY_DATA).child(str.toLowerCase()).child(Constants.ROUTES).child(str2.toUpperCase()));
        if (synchronizedDataSnapshot == null || synchronizedDataSnapshot.getValue() == null) {
            return new HashMap();
        }
        new DataObjectCreator();
        Map<String, Route> map = this._routeMap.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        for (DataSnapshot dataSnapshot : synchronizedDataSnapshot.getChildren()) {
            Route extractRoute = DataObjectCreator.extractRoute(dataSnapshot, str2);
            extractRoute.setStationType(str2);
            map.put(extractRoute.getId(), extractRoute);
        }
        this._routeMap.put(str, map);
        return map;
    }

    public long fetchEtaData(String str, String str2, String str3, String str4, String str5, String str6) {
        if (hasDailyEtaData(str, str2, str3, str4, str5, str6)) {
            return this._etaMap.get(str).get(str3).get(str4).get(str5).get(str6).longValue();
        }
        if (hasAvgEtaData(str, str2, str3, str5, str6)) {
            return this._etaMap.get(str).get(str3).get("-1").get(str5).get(str6).longValue();
        }
        return 0;
    }

    public synchronized void fetchEtaForAllRoute(String str, String str2) {
        if (!this._etaMap.containsKey(str)) {
            this._etaMap.put(str, new HashMap());
            if (str == null || str2 == null) {
                SimpleLogger.debug("route :" + str + " : " + str2);
            }
            DataSnapshot synchronizedDataSnapshot = FirebaseUtils.getSynchronizedDataSnapshot(new Firebase("https://dazzling-fire-3689.firebaseio.com/").child("production").child("staticEta").child(str).child(str2));
            if (!(synchronizedDataSnapshot == null || synchronizedDataSnapshot.getValue() == null)) {
                HashMap hashMap = new HashMap();
                for (DataSnapshot dataSnapshot : synchronizedDataSnapshot.getChildren()) {
                    HashMap hashMap2 = new HashMap();
                    for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                        HashMap hashMap3 = new HashMap();
                        for (DataSnapshot dataSnapshot3 : dataSnapshot2.getChildren()) {
                            HashMap hashMap4 = new HashMap();
                            for (DataSnapshot dataSnapshot4 : dataSnapshot3.getChildren()) {
                                hashMap4.put(dataSnapshot4.getKey(), (Long) dataSnapshot4.getValue());
                            }
                            hashMap3.put(dataSnapshot3.getKey(), hashMap4);
                        }
                        hashMap2.put(dataSnapshot2.getKey(), hashMap3);
                    }
                    hashMap.put(dataSnapshot.getKey(), hashMap2);
                }
                this._etaMap.put(str, hashMap);
            }
        }
    }

    public Map<String, List<Route>> getAllBusRoutes(String str, String str2) {
        fetchAllRoutes(str, "bus");
        HashMap hashMap = new HashMap();
        for (Route route : this._routeMap.get(str).values()) {
            if (route.getAgency().equalsIgnoreCase(str2)) {
                String replace = route.getName().replace("-", "");
                if (!hashMap.containsKey(replace)) {
                    hashMap.put(replace, new ArrayList());
                }
                ((List) hashMap.get(replace)).add(route);
            }
        }
        return hashMap;
    }

    public Route getRoute(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            SimpleLogger.debug(" null entries, route :" + str + " : " + str2 + " : " + str3);
            return null;
        } else if (str.equals("") || str2.equals("") || str3.equals("")) {
            SimpleLogger.debug(" empty entries, route :" + str + " : " + str2 + " : " + str3);
            return null;
        } else {
            Map<String, Route> map = this._routeMap.get(str);
            if (map == null) {
                map = fetchAllRoutes(str, str2);
            }
            if (map.containsKey(str3)) {
                return map.get(str3);
            }
            Route routeFromFirebase = StaticData.getRouteFromFirebase(str, str2, str3);
            if (routeFromFirebase == null) {
                PrintStream printStream = System.out;
                printStream.println("route does not exist for city : " + str + " and routeId : " + str3);
                return null;
            }
            routeFromFirebase.setStationType(str2);
            map.put(str3, routeFromFirebase);
            this._routeMap.put(str, map);
            return routeFromFirebase;
        }
    }

    public Stop getStop(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            SimpleLogger.debug("stop :" + str + " : " + str2 + " : " + str3);
            return null;
        }
        Map<String, Stop> map = this._stopMap.get(str);
        if (map == null) {
            map = StaticData.getStops(str, str2);
            this._stopMap.put(str, map);
        }
        if (map.containsKey(str3)) {
            return map.get(str3);
        }
        Stop stopFromFirebase = StaticData.getStopFromFirebase(str, str2, str3);
        map.put(str3, stopFromFirebase);
        this._stopMap.put(str, map);
        return stopFromFirebase;
    }

    public boolean hasAvgEtaData(String str, String str2, String str3, String str4, String str5) {
        return this._etaMap.containsKey(str) && this._etaMap.get(str).containsKey(str3) && this._etaMap.get(str).get(str3).containsKey("-1") && this._etaMap.get(str).get(str3).get("-1").containsKey(str4) && this._etaMap.get(str).get(str3).get("-1").get(str4).containsKey(str5);
    }

    public boolean hasDailyEtaData(String str, String str2, String str3, String str4, String str5, String str6) {
        return this._etaMap.containsKey(str) && this._etaMap.get(str).containsKey(str3) && this._etaMap.get(str).get(str3).containsKey(str4) && this._etaMap.get(str).get(str3).get(str4).containsKey(str5) && this._etaMap.get(str).get(str3).get(str4).get(str5).containsKey(str6);
    }

    public List<Route> getAllBusRoutes(String str) {
        ArrayList arrayList = new ArrayList();
        fetchAllRoutes(str, "bus");
        for (Route route : this._routeMap.get(str).values()) {
            if (!str.equalsIgnoreCase("kochi") || !RouteMappingUtils.containsKochiInactiveRoutes(route.getName())) {
                arrayList.add(route);
            }
        }
        return arrayList;
    }
}
