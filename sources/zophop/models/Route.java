package zophop.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class Route implements Serializable {
    private static final long serialVersionUID = 3;
    public String agency_id;
    public String agency_name;
    public String availabilityLevel;
    public ArrayList<Integer> consecutive_distances = new ArrayList<>();
    public String direction = "UP";
    public Stop direction_stop;
    public String feed_id;
    public Stop first_stop;
    public boolean hasFrequencyTrips;
    public Boolean isFreeRide;
    public String isLive;
    public Stop last_stop;
    public Boolean mTicketEnabled;
    public ArrayList<String> owners;
    public String polyline;
    public String reverse_routeId;
    public Boolean routePassEnabled;
    public String route_id;
    public String route_name;
    public String route_type;
    public Long short_id;
    public List<SPECIAL_FEATURE> specialFeatures;
    public ArrayList<String> spf;
    public StationType station_type;
    public ArrayList<String> stopIDSequence = new ArrayList<>();
    public Boolean stopPassEnabled;
    public ArrayList<Stop> stopSequenceWithDetails = new ArrayList<>();
    public HashMap<String, Integer> stop_index_map = new HashMap<>();
    public Boolean ticketingAllowed;
    public String transport_type;
    public ArrayList<Trip> tripList;
    public int ttSid;
    public int ttStatus;
    public int tt_type;

    public Route() {
        Boolean bool = Boolean.FALSE;
        this.ticketingAllowed = bool;
        this.mTicketEnabled = bool;
        this.isFreeRide = bool;
        this.routePassEnabled = bool;
        this.stopPassEnabled = bool;
        this.reverse_routeId = "";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        if (route.feed_id.equals(this.feed_id) && route.route_id.equals(this.route_id) && route.transport_type.equals(this.transport_type)) {
            return true;
        }
        return false;
    }

    public int getDistance(int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            i3 += this.consecutive_distances.get(i).intValue();
            i++;
        }
        return i3;
    }

    public int getIndex(String str) {
        Integer num = this.stop_index_map.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public Long getShort_id() {
        return this.short_id;
    }

    public JSONArray getSpecialFeatureJSonAraay() {
        JSONArray jSONArray = new JSONArray();
        List<SPECIAL_FEATURE> list = this.specialFeatures;
        if (list == null) {
            return jSONArray;
        }
        for (SPECIAL_FEATURE special_feature : list) {
            jSONArray.put(special_feature.name());
        }
        return jSONArray;
    }

    public List<SPECIAL_FEATURE> getSpecialFeatures() {
        List<SPECIAL_FEATURE> list = this.specialFeatures;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getSpf() {
        ArrayList<String> arrayList = this.spf;
        return arrayList == null ? new ArrayList() : arrayList;
    }

    public int getTtSid() {
        return this.ttSid;
    }

    public int getTtStatus() {
        return this.ttStatus;
    }

    public int getTt_type() {
        return this.tt_type;
    }

    public boolean hasTripsOnDay(String str) {
        Iterator<Trip> it = this.tripList.iterator();
        while (it.hasNext()) {
            if (it.next().getWeek_days_data().isOn(str)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.route_id.hashCode();
    }

    public void setShort_id(Long l) {
        this.short_id = l;
    }

    public void setTtSid(int i) {
        this.ttSid = i;
    }

    public void setTtStatus(int i) {
        this.ttStatus = i;
    }

    public void setTt_type(int i) {
        this.tt_type = i;
    }

    public int getDistance(String str, String str2) {
        int index = getIndex(str);
        int index2 = getIndex(str2);
        int i = 0;
        if (index >= index2) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.stopSequenceWithDetails.size()) {
                    break;
                } else if (this.stopSequenceWithDetails.get(i2).getStop_id().equals(str)) {
                    index = i2;
                    break;
                } else {
                    i2++;
                }
            }
        }
        while (index < index2) {
            i += this.consecutive_distances.get(index).intValue();
            index++;
        }
        return i;
    }
}
