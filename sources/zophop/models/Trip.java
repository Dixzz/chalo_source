package zophop.models;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class Trip implements Serializable {
    private static final long serialVersionUID = 3;
    private String agency_id;
    private String agency_name;
    public String availabilityLevel;
    private Stop direction_stop = null;
    private int duration;
    private boolean extrapolated = false;
    private String feed_id = null;
    private Stop first_stop = null;
    private String frequency_data = null;
    private ArrayList<FrequencyTuple> frequency_data_array = null;
    private String frequency_id;
    private boolean isFrequencyTrip = false;
    private Stop last_stop = null;
    private String route_id = null;
    private String route_name = null;
    private String service_id;
    private ArrayList<SPECIAL_FEATURE> special_features = null;
    public ArrayList<String> spf = new ArrayList<>();
    private StationType station_type;
    private ArrayList<StopSequence> stopSequenceWithArrivalTime = null;
    private String transport_type = null;
    private String trip_id = null;
    public Integer ttSid;
    public Integer ttStatus;
    private int tt_type;
    private String week_day_data;
    private WeekDaysData week_days_data;

    public boolean equals(Object obj) {
        if (!(obj instanceof Trip)) {
            return false;
        }
        Trip trip = (Trip) obj;
        if (this.trip_id.equals(trip.trip_id) && this.transport_type.equals(trip.transport_type)) {
            return true;
        }
        return false;
    }

    public String getAgency_id() {
        return this.agency_id;
    }

    public String getAgency_name() {
        return this.agency_name;
    }

    public String getAvailabilityLevel() {
        return this.availabilityLevel;
    }

    public Stop getDirection_stop() {
        return this.direction_stop;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getEnd_time() {
        ArrayList<StopSequence> arrayList = this.stopSequenceWithArrivalTime;
        return arrayList.get(arrayList.size() - 1).getArrival_time();
    }

    public String getFeed_id() {
        return this.feed_id;
    }

    public Stop getFirst_stop() {
        return this.first_stop;
    }

    public String getFrequency_data() {
        String str = this.frequency_data;
        if (str != null) {
            return str;
        }
        ArrayList<FrequencyTuple> arrayList = this.frequency_data_array;
        if (arrayList == null) {
            return null;
        }
        Iterator<FrequencyTuple> it = arrayList.iterator();
        String str2 = "";
        while (it.hasNext()) {
            FrequencyTuple next = it.next();
            StringBuilder i0 = hj1.i0(str2);
            i0.append(next.start_time);
            i0.append(",");
            i0.append(next.end_time);
            i0.append(",");
            str2 = hj1.X(i0, next.frequency, ",");
        }
        return hj1.a0(new StringBuilder(), StringUtils.chop(str2), "\n");
    }

    public ArrayList<FrequencyTuple> getFrequency_data_array() {
        return this.frequency_data_array;
    }

    public String getFrequency_id() {
        return this.frequency_id;
    }

    public Stop getLast_stop() {
        return this.last_stop;
    }

    public Integer getNumber_of_stops() {
        return Integer.valueOf(this.stopSequenceWithArrivalTime.size());
    }

    public String getRoute_id() {
        return this.route_id;
    }

    public String getRoute_name() {
        return this.route_name;
    }

    public String getService_id() {
        return this.service_id;
    }

    public ArrayList<SPECIAL_FEATURE> getSpecial_features() {
        return this.special_features;
    }

    public ArrayList<String> getSpf() {
        return this.spf;
    }

    public int getStart_time() {
        return this.stopSequenceWithArrivalTime.get(0).getArrival_time();
    }

    public StationType getStation_type() {
        return this.station_type;
    }

    public ArrayList<StopSequence> getStopSequenceWithArrivalTime() {
        return this.stopSequenceWithArrivalTime;
    }

    public String getTransport_type() {
        return this.transport_type;
    }

    public Integer getTrip_duration() {
        ArrayList<StopSequence> arrayList = this.stopSequenceWithArrivalTime;
        return Integer.valueOf(arrayList.get(arrayList.size() - 1).getArrival_time() - this.stopSequenceWithArrivalTime.get(0).getArrival_time());
    }

    public String getTrip_id() {
        return this.trip_id;
    }

    public Integer getTtSid() {
        return this.ttSid;
    }

    public Integer getTtStatus() {
        return this.ttStatus;
    }

    public int getTt_type() {
        return this.tt_type;
    }

    public String getWeek_day_data() {
        return this.week_day_data;
    }

    public WeekDaysData getWeek_days_data() {
        return this.week_days_data;
    }

    public int hashCode() {
        return this.trip_id.hashCode();
    }

    public boolean isExtrapolated() {
        return this.extrapolated;
    }

    public boolean isFrequencyTrip() {
        return this.isFrequencyTrip;
    }

    public void setAgency_id(String str) {
        this.agency_id = str;
    }

    public void setAgency_name(String str) {
        this.agency_name = str;
    }

    public void setAvailabilityLevel(String str) {
        this.availabilityLevel = str;
    }

    public void setDirection_stop(Stop stop) {
        this.direction_stop = stop;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setExtrapolated(boolean z) {
        this.extrapolated = z;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    public void setFirst_stop(Stop stop) {
        this.first_stop = stop;
    }

    public void setFrequencyTrip(boolean z) {
        this.isFrequencyTrip = z;
    }

    public void setFrequency_data(String str) {
        this.frequency_data = str;
    }

    public void setFrequency_data_array(ArrayList<FrequencyTuple> arrayList) {
        this.frequency_data_array = arrayList;
    }

    public void setFrequency_id(String str) {
        this.frequency_id = str;
    }

    public void setLast_stop(Stop stop) {
        this.last_stop = stop;
    }

    public void setRoute_id(String str) {
        this.route_id = str;
    }

    public void setRoute_name(String str) {
        this.route_name = str;
    }

    public void setService_id(String str) {
        this.service_id = str;
    }

    public void setSpecial_features(ArrayList<SPECIAL_FEATURE> arrayList) {
        this.special_features = arrayList;
    }

    public void setStation_type(StationType stationType) {
        this.station_type = stationType;
    }

    public void setStopSequenceWithArrivalTime(ArrayList<StopSequence> arrayList) {
        this.stopSequenceWithArrivalTime = arrayList;
    }

    public void setTransport_type(String str) {
        this.transport_type = str;
    }

    public void setTrip_id(String str) {
        this.trip_id = str;
    }

    public void setTtSid(Integer num) {
        this.ttSid = num;
    }

    public void setTtStatus(Integer num) {
        this.ttStatus = num;
    }

    public void setTt_type(int i) {
        this.tt_type = i;
    }

    public void setWeek_day_data(String str) {
        this.week_day_data = str;
    }

    public void setWeek_days_data(WeekDaysData weekDaysData) {
        this.week_days_data = weekDaysData;
    }

    public void setFrequency_data_array(String str) {
        ArrayList<FrequencyTuple> arrayList = new ArrayList<>();
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i += 3) {
            FrequencyTuple frequencyTuple = new FrequencyTuple();
            frequencyTuple.start_time = Integer.parseInt(split[i]);
            frequencyTuple.end_time = Integer.parseInt(split[i + 1]);
            frequencyTuple.frequency = Integer.parseInt(split[i + 2]);
            arrayList.add(frequencyTuple);
        }
        if (arrayList.size() > 0) {
            this.frequency_data_array = arrayList;
        }
    }

    public void setSpecial_features(String str) {
        String[] split = str.split(ProductDiscountsObject.KEY_DELIMITER);
        this.special_features = new ArrayList<>();
        SPECIAL_FEATURE[] values = SPECIAL_FEATURE.values();
        for (int i = 0; i < 6; i++) {
            SPECIAL_FEATURE special_feature = values[i];
            for (String str2 : split) {
                if (str2.toUpperCase().equals(special_feature.toString())) {
                    this.special_features.add(special_feature);
                }
            }
        }
    }
}
