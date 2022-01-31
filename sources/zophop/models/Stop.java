package zophop.models;

import java.io.BufferedReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Stop implements Serializable {
    private static final long serialVersionUID = 1;
    private City city;
    private String feed_id;
    public ArrayList<String> owners;
    public Long short_id;
    private StationType station_type;
    private String stop_code;
    private String stop_id;
    private double stop_lat;
    private double stop_lon;
    private String stop_name;
    private String transport_type;

    public static HashMap<String, Stop> getStops(String str) throws Exception {
        BufferedReader p = ec6.p(str);
        HashMap<String, Integer> q = ec6.q(p.readLine());
        HashMap<String, Stop> hashMap = new HashMap<>();
        while (true) {
            String readLine = p.readLine();
            if (readLine != null) {
                String[] split = readLine.split(",", -1);
                Stop stop = new Stop();
                if (q.containsKey("stop_id")) {
                    stop.stop_id = split[q.get("stop_id").intValue()];
                }
                if (q.containsKey("stop_name")) {
                    stop.stop_name = split[q.get("stop_name").intValue()];
                }
                if (q.containsKey("stop_lat")) {
                    stop.stop_lat = Double.parseDouble(split[q.get("stop_lat").intValue()]);
                }
                if (q.containsKey("stop_lon")) {
                    stop.stop_lon = Double.parseDouble(split[q.get("stop_lon").intValue()]);
                }
                if (q.containsKey("stop_code")) {
                    stop.stop_code = split[q.get("stop_code").intValue()];
                }
                if (q.containsKey("station_type")) {
                    stop.station_type = StationType.getStationType(split[q.get("station_type").intValue()]);
                }
                if (q.containsKey("transport_type")) {
                    stop.transport_type = split[q.get("transport_type").intValue()];
                }
                hashMap.put(stop.getStop_id(), stop);
            } else {
                p.close();
                return hashMap;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Stop stop = (Stop) obj;
        if (this.city != stop.city) {
            return false;
        }
        String str = this.feed_id;
        if (str == null) {
            if (stop.feed_id != null) {
                return false;
            }
        } else if (!str.equals(stop.feed_id)) {
            return false;
        }
        if (this.station_type != stop.station_type) {
            return false;
        }
        String str2 = this.stop_id;
        if (str2 == null) {
            if (stop.stop_id != null) {
                return false;
            }
        } else if (!str2.equals(stop.stop_id)) {
            return false;
        }
        String str3 = this.transport_type;
        if (str3 == null) {
            if (stop.transport_type != null) {
                return false;
            }
        } else if (!str3.equals(stop.transport_type)) {
            return false;
        }
        return true;
    }

    public City getCity() {
        return this.city;
    }

    public String getFeed_id() {
        return this.feed_id;
    }

    public Long getShort_id() {
        return this.short_id;
    }

    public StationType getStation_type() {
        return this.station_type;
    }

    public String getStop_code() {
        return this.stop_code;
    }

    public String getStop_id() {
        return this.stop_id;
    }

    public double getStop_lat() {
        return this.stop_lat;
    }

    public double getStop_lon() {
        return this.stop_lon;
    }

    public String getStop_name() {
        return this.stop_name;
    }

    public String getTranport_type() {
        return this.transport_type;
    }

    public int hashCode() {
        City city2 = this.city;
        int i = 0;
        int hashCode = ((city2 == null ? 0 : city2.hashCode()) + 31) * 31;
        String str = this.feed_id;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        StationType stationType = this.station_type;
        int hashCode3 = (hashCode2 + (stationType == null ? 0 : stationType.hashCode())) * 31;
        String str2 = this.stop_id;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.transport_type;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public void setCity(City city2) {
        this.city = city2;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    public void setStation_type(StationType stationType) {
        this.station_type = stationType;
    }

    public void setStop_code(String str) {
        this.stop_code = str;
    }

    public void setStop_id(String str) {
        this.stop_id = str;
    }

    public void setStop_lat(double d) {
        this.stop_lat = d;
    }

    public void setStop_lon(double d) {
        this.stop_lon = d;
    }

    public void setStop_name(String str) {
        this.stop_name = str;
    }

    public void setTranport_type(String str) {
        this.transport_type = str;
    }

    public String toString() {
        return this.stop_id + "," + this.stop_name + "," + this.transport_type;
    }
}
