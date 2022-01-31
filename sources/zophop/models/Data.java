package zophop.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import zophop.models.preproccessing.RoadConnection;
import zophop.neo4j_graphalgo.calculators.TicketHandler;

public class Data implements Serializable {
    private static final long serialVersionUID = 4;
    private HashMap<String, HashMap<String, Stop>> agencyWiseStops = new HashMap<>();
    private City city;
    private Map fares = new HashMap();
    private Metadata metaData = new Metadata();
    private Map passes = new HashMap();
    private HashMap<String, ArrayList<RoadConnection>> roadConnectionMap = new HashMap<>();
    private HashMap<String, Route> routeIdToRoutesMap = new HashMap<>();
    private HashMap<String, ArrayList<String>> routesFromStop = new HashMap<>();
    private HashMap<String, ArrayList<String>> routesStopSequence = new HashMap<>();
    private HashMap<StationType, ArrayList<Route>> stationTypeRoutesMaps = new HashMap<>();
    private HashMap<StationType, ArrayList<Stop>> stationtypeStopsMaps = new HashMap<>();
    private HashMap<String, Stop> stopIdToStopsMap = new HashMap<>();
    private HashMap<String, HashMap<String, ArrayList<TripAndArrivalInfoTuple>>> stopToRouteTripTimingMap = new HashMap<>();
    private TicketHandler ticketHandler;
    private HashMap<String, Trip> tripIdToTripMap = new HashMap<>();
    private HashMap<String, HashMap<String, ArrayList<TripAndArrivalInfoTuple>>> tripsBetweenStopTuple = new HashMap<>();

    public static Data deserialize(String str) throws ClassNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Data data = (Data) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return data;
    }

    public static void serialize(Data data, String str) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(data);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public void addRoadConnection(String str, RoadConnection roadConnection) {
        ArrayList<RoadConnection> arrayList = this.roadConnectionMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(roadConnection);
        this.roadConnectionMap.put(str, arrayList);
    }

    public void addRoute(Route route) throws Exception {
        ArrayList<Route> arrayList;
        if (!this.routeIdToRoutesMap.containsKey(route.route_id)) {
            this.routeIdToRoutesMap.put(route.route_id, route);
            if (this.stationTypeRoutesMaps.containsKey(route.station_type)) {
                arrayList = this.stationTypeRoutesMaps.get(route.station_type);
            } else {
                arrayList = new ArrayList<>();
            }
            arrayList.add(route);
            this.stationTypeRoutesMaps.put(route.station_type, arrayList);
            return;
        }
        throw new Exception("route already exists");
    }

    public void addRouteFromStop(String str, String str2) {
        ArrayList<String> arrayList;
        if (this.routesFromStop.containsKey(str)) {
            arrayList = this.routesFromStop.get(str);
        } else {
            arrayList = new ArrayList<>();
        }
        if (!arrayList.contains(str2)) {
            arrayList.add(str2);
        }
        this.routesFromStop.put(str, arrayList);
    }

    public void addRouteStopSequence(String str, ArrayList<String> arrayList) {
        this.routesStopSequence.put(str, arrayList);
    }

    public void addStop(Stop stop) throws Exception {
        ArrayList<Stop> arrayList;
        if (!this.stopIdToStopsMap.containsKey(stop.getStop_id())) {
            this.stopIdToStopsMap.put(stop.getStop_id(), stop);
            if (this.stationtypeStopsMaps.containsKey(stop.getStation_type())) {
                arrayList = this.stationtypeStopsMaps.get(stop.getStation_type());
            } else {
                arrayList = new ArrayList<>();
            }
            arrayList.add(stop);
            this.stationtypeStopsMaps.put(stop.getStation_type(), arrayList);
            return;
        }
        throw new Exception("stop already exists");
    }

    public void addTrip(Trip trip) {
        this.tripIdToTripMap.put(trip.getTrip_id(), trip);
    }

    public void addTripAndArrivalInfoTuple(String str, TripAndArrivalInfoTuple tripAndArrivalInfoTuple) {
        HashMap<String, ArrayList<TripAndArrivalInfoTuple>> hashMap = this.stopToRouteTripTimingMap.get(str);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        String route_id = tripAndArrivalInfoTuple.getTrip().getRoute_id();
        ArrayList<TripAndArrivalInfoTuple> arrayList = hashMap.get(route_id);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(tripAndArrivalInfoTuple);
        Collections.sort(arrayList);
        hashMap.put(route_id, arrayList);
        this.stopToRouteTripTimingMap.put(str, hashMap);
    }

    public void addTripAndArrivalInfoTupleForInBetweenStops(String str, String str2, TripAndArrivalInfoTuple tripAndArrivalInfoTuple) {
        HashMap<String, ArrayList<TripAndArrivalInfoTuple>> hashMap = this.tripsBetweenStopTuple.get(str);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        ArrayList<TripAndArrivalInfoTuple> arrayList = hashMap.get(str2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(tripAndArrivalInfoTuple);
        Collections.sort(arrayList);
        hashMap.put(str2, arrayList);
        this.tripsBetweenStopTuple.put(str, hashMap);
    }

    public Iterable<Stop> getAgencyStops(String str) {
        HashMap<String, Stop> hashMap = this.agencyWiseStops.get(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : hashMap.keySet()) {
            arrayList.add(hashMap.get(str2));
        }
        return arrayList;
    }

    public HashMap<String, HashMap<String, Stop>> getAgencyWiseStops() {
        return this.agencyWiseStops;
    }

    public Iterable<Route> getAllRoutes() {
        return this.routeIdToRoutesMap.values();
    }

    public Iterable<Stop> getAllStops() {
        return this.stopIdToStopsMap.values();
    }

    public Iterable<Trip> getAllTrips() {
        return this.tripIdToTripMap.values();
    }

    public ArrayList<TripAndArrivalInfoTuple> getAllTripsFromStop(String str) {
        HashMap<String, ArrayList<TripAndArrivalInfoTuple>> hashMap = this.tripsBetweenStopTuple.get(str);
        ArrayList<TripAndArrivalInfoTuple> arrayList = new ArrayList<>();
        if (hashMap == null) {
            return arrayList;
        }
        for (ArrayList<TripAndArrivalInfoTuple> arrayList2 : hashMap.values()) {
            Iterator<TripAndArrivalInfoTuple> it = arrayList2.iterator();
            while (it.hasNext()) {
                TripAndArrivalInfoTuple next = it.next();
                if (!arrayList.contains(next)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<TripAndArrivalInfoTuple> getAllTripsFromStopAndRoute(String str, String str2) {
        ArrayList<TripAndArrivalInfoTuple> arrayList = this.stopToRouteTripTimingMap.get(str).get(str2);
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public TripAndArrivalInfoTuple getArrivalTimeAtStopOfTrip(String str, String str2) {
        Trip trip = this.tripIdToTripMap.get(str2);
        Iterator<StopSequence> it = trip.getStopSequenceWithArrivalTime().iterator();
        while (it.hasNext()) {
            StopSequence next = it.next();
            if (next.getStop().getStop_id().equals(str)) {
                TripAndArrivalInfoTuple tripAndArrivalInfoTuple = new TripAndArrivalInfoTuple();
                tripAndArrivalInfoTuple.setArrival_time(next.getArrival_time());
                tripAndArrivalInfoTuple.setPlatform(next.getPlatform());
                tripAndArrivalInfoTuple.setTrip(trip);
                return tripAndArrivalInfoTuple;
            }
        }
        return null;
    }

    public City getCity() {
        return this.city;
    }

    public Map getFares() {
        return this.fares;
    }

    public Iterable<Stop> getFilteredStopIds(String str) {
        Iterable<Stop> allStops = getAllStops();
        HashMap hashMap = new HashMap();
        for (Stop stop : allStops) {
            ArrayList<String> arrayList = stop.owners;
            if (arrayList == null || arrayList.contains(str)) {
                hashMap.put(stop.getStop_id(), stop);
            }
        }
        return hashMap.values();
    }

    public Metadata getMetaData() {
        return this.metaData;
    }

    public Map getPasses() {
        return this.passes;
    }

    public ArrayList<RoadConnection> getRoadConnectionsFromStop(String str) {
        ArrayList<RoadConnection> arrayList = this.roadConnectionMap.get(str);
        if (arrayList == null || arrayList.size() == 0) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    public Route getRoute(String str) {
        return this.routeIdToRoutesMap.get(str);
    }

    public Iterable<String> getRouteIdsForRouteName(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<Route> it = this.stationTypeRoutesMaps.get(str).iterator();
        while (it.hasNext()) {
            Route next = it.next();
            if (next.route_name.equalsIgnoreCase(str2)) {
                arrayList.add(next.route_id);
            }
        }
        return arrayList;
    }

    public Iterable<Route> getRoutes(StationType stationType) {
        return this.stationTypeRoutesMaps.get(stationType);
    }

    public Iterable<String> getRoutesBetweenStops(String str, String str2) {
        ArrayList<TripAndArrivalInfoTuple> arrayList;
        HashMap<String, ArrayList<TripAndArrivalInfoTuple>> hashMap = this.tripsBetweenStopTuple.get(str);
        HashSet hashSet = new HashSet();
        if (hashMap == null || (arrayList = hashMap.get(str2)) == null) {
            return hashSet;
        }
        Iterator<TripAndArrivalInfoTuple> it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getTrip().getRoute_id());
        }
        return hashSet;
    }

    public ArrayList<String> getRoutesFromStop(String str) {
        ArrayList<String> arrayList = this.routesFromStop.get(str);
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public Iterable<StationType> getStationTypes() {
        return this.stationtypeStopsMaps.keySet();
    }

    public Stop getStop(String str) {
        return this.stopIdToStopsMap.get(str);
    }

    public int getStopSequenceNumber(String str, String str2) {
        ArrayList<String> arrayList = this.routesStopSequence.get(str);
        for (int i = 0; i < arrayList.size(); i++) {
            if (str2.equals(arrayList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<String> getStopSequenceOfRoute(String str) {
        return this.routesStopSequence.get(str);
    }

    public Iterable<Stop> getStops(StationType stationType) {
        return this.stationtypeStopsMaps.get(stationType);
    }

    public TicketHandler getTicketHandler() {
        return this.ticketHandler;
    }

    public Trip getTrip(String str) {
        return this.tripIdToTripMap.get(str);
    }

    public HashMap<String, HashMap<String, ArrayList<TripAndArrivalInfoTuple>>> getTripsBetweenStopTuple() {
        return this.tripsBetweenStopTuple;
    }

    public ArrayList<TripAndArrivalInfoTuple> getTripsBetweenStops(String str, String str2) {
        HashMap<String, ArrayList<TripAndArrivalInfoTuple>> hashMap = this.tripsBetweenStopTuple.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str2);
    }

    public boolean hasStationType(StationType stationType) {
        for (StationType stationType2 : this.stationTypeRoutesMaps.keySet()) {
            if (stationType2.equals(stationType)) {
                return true;
            }
        }
        return false;
    }

    public void putRoadConnection(String str, ArrayList<RoadConnection> arrayList) {
        this.roadConnectionMap.put(str, arrayList);
    }

    public void setAgencyWiseStops(HashMap<String, HashMap<String, Stop>> hashMap) {
        this.agencyWiseStops = hashMap;
    }

    public void setCity(City city2) {
        this.city = city2;
    }

    public void setFares(Map map) {
        this.fares = map;
    }

    public void setMetaData(Metadata metadata) {
        this.metaData = metadata;
    }

    public void setPasses(Map map) {
        this.passes = map;
    }

    public void setTicketHandler(TicketHandler ticketHandler2) {
        this.ticketHandler = ticketHandler2;
    }

    public void updateRoute(Route route) throws Exception {
        ArrayList<Route> arrayList;
        this.routeIdToRoutesMap.put(route.route_id, route);
        if (this.stationTypeRoutesMaps.containsKey(route.station_type)) {
            arrayList = this.stationTypeRoutesMaps.get(route.station_type);
        } else {
            arrayList = new ArrayList<>();
        }
        arrayList.add(route);
        this.stationTypeRoutesMaps.put(route.station_type, arrayList);
    }
}
