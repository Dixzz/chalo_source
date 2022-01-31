package zophop.models;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;

public class Summary implements Comparable<Summary> {
    public String agency_name;
    private double distance;
    private String feed_id;
    private StationType station_type;
    private Stop stop;
    private String stop_id;
    public ArrayList<TripAndArrivalInfoTuple> summary;
    private String transport_type;

    public double getDistance() {
        return this.distance;
    }

    public String getFeed_id() {
        return this.feed_id;
    }

    public StationType getStation_type() {
        return this.station_type;
    }

    public Stop getStop() {
        return this.stop;
    }

    public String getStop_id() {
        return this.stop_id;
    }

    public String getTransport_type() {
        return this.transport_type;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    public void setStation_type(String str) {
        this.station_type = StationType.getStationType(str);
    }

    public void setStop(Stop stop2) {
        this.stop = stop2;
    }

    public void setStop_id(String str) {
        this.stop_id = str;
    }

    public void setTransport_type(String str) {
        this.transport_type = str;
    }

    public int compareTo(Summary summary2) {
        return this.distance - summary2.distance <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? -1 : 1;
    }

    public void setStation_type(StationType stationType) {
        this.station_type = stationType;
    }
}
