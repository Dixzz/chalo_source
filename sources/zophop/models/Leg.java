package zophop.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Leg implements Serializable {
    public String agency_name;
    public String availabilityLevel;
    public Stop direction_stop;
    public String direction_stop_id;
    public int distance;
    public String end_place_name;
    public int end_time;
    public ExtraTrips extraTrips;
    public Stop first_stop;
    public String first_stop_id;
    public int frequency;
    public double from_lat;
    public double from_lon;
    public ArrayList<StopSequence> intermediateStops = null;
    public boolean isFrequencyLeg;
    public Stop last_stop;
    public String last_stop_id;
    public LegMode mode;
    public String platform;
    public String polyline = null;
    public String route_id;
    public String route_name;
    public ArrayList<SPECIAL_FEATURE> special_features;
    public String start_place_name;
    public int start_time;
    public StationType station_type;
    public double to_lat;
    public double to_lon;
    public String trip_id;
    public int ttSid = 0;
    public int ttStatus = 0;
    public int tt_type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Leg leg = (Leg) obj;
        String str = this.agency_name;
        if (str == null) {
            if (leg.agency_name != null) {
                return false;
            }
        } else if (!str.equals(leg.agency_name)) {
            return false;
        }
        String str2 = this.direction_stop_id;
        if (str2 == null) {
            if (leg.direction_stop_id != null) {
                return false;
            }
        } else if (!str2.equals(leg.direction_stop_id)) {
            return false;
        }
        if (Double.doubleToLongBits((double) this.distance) != Double.doubleToLongBits((double) leg.distance)) {
            return false;
        }
        String str3 = this.end_place_name;
        if (str3 == null) {
            if (leg.end_place_name != null) {
                return false;
            }
        } else if (!str3.equals(leg.end_place_name)) {
            return false;
        }
        if (this.end_time != leg.end_time) {
            return false;
        }
        String str4 = this.first_stop_id;
        if (str4 == null) {
            if (leg.first_stop_id != null) {
                return false;
            }
        } else if (!str4.equals(leg.first_stop_id)) {
            return false;
        }
        if (Double.doubleToLongBits(this.from_lat) != Double.doubleToLongBits(leg.from_lat) || Double.doubleToLongBits(this.from_lon) != Double.doubleToLongBits(leg.from_lon)) {
            return false;
        }
        ArrayList<StopSequence> arrayList = this.intermediateStops;
        if (arrayList == null) {
            if (leg.intermediateStops != null) {
                return false;
            }
        } else if (!arrayList.equals(leg.intermediateStops)) {
            return false;
        }
        String str5 = this.last_stop_id;
        if (str5 == null) {
            if (leg.last_stop_id != null) {
                return false;
            }
        } else if (!str5.equals(leg.last_stop_id)) {
            return false;
        }
        if (this.mode != leg.mode) {
            return false;
        }
        String str6 = this.polyline;
        if (str6 == null) {
            if (leg.polyline != null) {
                return false;
            }
        } else if (!str6.equals(leg.polyline)) {
            return false;
        }
        String str7 = this.route_name;
        if (str7 == null) {
            if (leg.route_name != null) {
                return false;
            }
        } else if (!str7.equals(leg.route_name)) {
            return false;
        }
        ArrayList<SPECIAL_FEATURE> arrayList2 = this.special_features;
        if (arrayList2 == null) {
            if (leg.special_features != null) {
                return false;
            }
        } else if (!arrayList2.equals(leg.special_features)) {
            return false;
        }
        String str8 = this.start_place_name;
        if (str8 == null) {
            if (leg.start_place_name != null) {
                return false;
            }
        } else if (!str8.equals(leg.start_place_name)) {
            return false;
        }
        if (this.start_time != leg.start_time || this.station_type != leg.station_type || Double.doubleToLongBits(this.to_lat) != Double.doubleToLongBits(leg.to_lat) || Double.doubleToLongBits(this.to_lon) != Double.doubleToLongBits(leg.to_lon)) {
            return false;
        }
        String str9 = this.trip_id;
        if (str9 == null) {
            if (leg.trip_id != null) {
                return false;
            }
        } else if (!str9.equals(leg.trip_id)) {
            return false;
        }
        return true;
    }

    public double getDistanceInKm() {
        return (((double) this.distance) * 1.0d) / 1000.0d;
    }

    public ArrayList<SPECIAL_FEATURE> getSpecial_features() {
        return this.special_features;
    }

    public int hashCode() {
        String str = this.agency_name;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.direction_stop_id;
        int hashCode2 = hashCode + (str2 == null ? 0 : str2.hashCode());
        long doubleToLongBits = Double.doubleToLongBits((double) this.distance);
        int i2 = ((hashCode2 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        String str3 = this.end_place_name;
        int hashCode3 = (((i2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.end_time) * 31;
        String str4 = this.first_stop_id;
        int hashCode4 = hashCode3 + (str4 == null ? 0 : str4.hashCode());
        long doubleToLongBits2 = Double.doubleToLongBits(this.from_lat);
        long doubleToLongBits3 = Double.doubleToLongBits(this.from_lon);
        int i3 = ((((hashCode4 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31;
        ArrayList<StopSequence> arrayList = this.intermediateStops;
        int hashCode5 = (i3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str5 = this.last_stop_id;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        LegMode legMode = this.mode;
        int hashCode7 = (hashCode6 + (legMode == null ? 0 : legMode.hashCode())) * 31;
        String str6 = this.polyline;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.route_name;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        ArrayList<SPECIAL_FEATURE> arrayList2 = this.special_features;
        int hashCode10 = (hashCode9 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        String str8 = this.start_place_name;
        int hashCode11 = (((hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31) + this.start_time) * 31;
        StationType stationType = this.station_type;
        int hashCode12 = hashCode11 + (stationType == null ? 0 : stationType.hashCode());
        long doubleToLongBits4 = Double.doubleToLongBits(this.to_lat);
        long doubleToLongBits5 = Double.doubleToLongBits(this.to_lon);
        int i4 = ((((hashCode12 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31;
        String str9 = this.trip_id;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return i4 + i;
    }

    public void setSpecial_features(String str) {
        String[] split = str.split("[,:]");
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
