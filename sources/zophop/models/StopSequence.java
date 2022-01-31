package zophop.models;

import java.io.Serializable;

public class StopSequence implements Comparable<StopSequence>, Serializable {
    private static final long serialVersionUID = 1;
    private int arrival_time;
    private String feed_id;
    private String platform;
    private Stop stop;
    private String stop_id;
    private int stop_sequence;
    private String transport_type;

    public boolean equals(Object obj) {
        String str;
        if (!(obj instanceof StopSequence)) {
            return false;
        }
        StopSequence stopSequence = (StopSequence) obj;
        if (stopSequence.stop_id != null && this.stop_id != null && !stopSequence.getStop_id().equals(this.stop_id)) {
            return false;
        }
        Stop stop2 = stopSequence.stop;
        if (stop2 != null && this.stop != null && !stop2.getStop_id().equals(this.stop.getStop_id())) {
            return false;
        }
        String str2 = stopSequence.stop_id;
        if (str2 != null && this.stop_id == null) {
            return false;
        }
        if (str2 == null && this.stop_id != null) {
            return false;
        }
        Stop stop3 = stopSequence.stop;
        if (stop3 != null && this.stop == null) {
            return false;
        }
        if (stop3 == null && this.stop != null) {
            return false;
        }
        String str3 = stopSequence.platform;
        if (str3 != null && (str = this.platform) != null && !str3.equals(str)) {
            return false;
        }
        String str4 = stopSequence.platform;
        if (str4 != null && this.platform == null) {
            return false;
        }
        if ((str4 != null || this.platform == null) && stopSequence.arrival_time == this.arrival_time) {
            return true;
        }
        return false;
    }

    public int getArrival_time() {
        return this.arrival_time;
    }

    public String getFeed_id() {
        return this.feed_id;
    }

    public String getPlatform() {
        return this.platform;
    }

    public Stop getStop() {
        return this.stop;
    }

    public String getStop_id() {
        String str = this.stop_id;
        if (str != null) {
            return str;
        }
        Stop stop2 = this.stop;
        if (stop2 != null) {
            return stop2.getStop_id();
        }
        return null;
    }

    public int getStop_sequence() {
        return this.stop_sequence;
    }

    public String getTransport_type() {
        return this.transport_type;
    }

    public void setArrival_time(int i) {
        this.arrival_time = i;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setStop(Stop stop2) {
        this.stop = stop2;
    }

    public void setStop_id(String str) {
        this.stop_id = str;
    }

    public void setStop_sequence(int i) {
        this.stop_sequence = i;
    }

    public void setTransport_type(String str) {
        this.transport_type = str;
    }

    public int compareTo(StopSequence stopSequence) {
        return this.arrival_time - stopSequence.arrival_time;
    }
}
