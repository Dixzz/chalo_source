package app.zophop.models.http_response;

import android.util.Pair;
import app.zophop.models.Stop;
import app.zophop.models.TimeInterval;
import java.util.List;
import zophop.models.SPECIAL_FEATURE;

public class TripSummary {
    private String _agencyName;
    private final int _arrivalTime;
    private String _availabilityLevel;
    private final Stop _directionStop;
    private final Stop _firstStop;
    private List<Pair<TimeInterval, Integer>> _frequencyList;
    private final boolean _frequencyTrip;
    private final Stop _lastStop;
    private String _platform;
    private final String _routeId;
    private final String _routeName;
    private final List<SPECIAL_FEATURE> _specialFeatures;
    private final String _tripId;
    private int _ttStatus;
    private int _ttStatusId;
    private int _ttType;

    public TripSummary(String str, int i, Stop stop, Stop stop2, Stop stop3, String str2, String str3, boolean z, List<SPECIAL_FEATURE> list) {
        this._tripId = str;
        this._arrivalTime = i;
        this._firstStop = stop;
        this._lastStop = stop2;
        this._directionStop = stop3;
        this._routeId = str2;
        this._frequencyTrip = z;
        this._specialFeatures = list;
        this._routeName = str3;
    }

    public String getAgencyName() {
        return this._agencyName;
    }

    public int getArrivalTime() {
        return this._arrivalTime;
    }

    public String getAvailabilityLevel() {
        return this._availabilityLevel;
    }

    public Stop getDirectionStop() {
        return this._directionStop;
    }

    public Stop getFirstStop() {
        return this._firstStop;
    }

    public List<Pair<TimeInterval, Integer>> getFrequencyList() {
        return this._frequencyList;
    }

    public Stop getLastStop() {
        return this._lastStop;
    }

    public String getPlatform() {
        return this._platform;
    }

    public String getRouteId() {
        return this._routeId;
    }

    public String getRouteName() {
        return this._routeName;
    }

    public List<SPECIAL_FEATURE> getSpecialFeatures() {
        return this._specialFeatures;
    }

    public String getTripId() {
        return this._tripId;
    }

    public int getTtStatus() {
        return this._ttStatus;
    }

    public int getTtStatusId() {
        return this._ttStatusId;
    }

    public int getTtType() {
        return this._ttType;
    }

    public boolean isFrequencyTrip() {
        return this._frequencyTrip;
    }

    public void setAgencyName(String str) {
        this._agencyName = str;
    }

    public void setAvailabilityLevel(String str) {
        this._availabilityLevel = str;
    }

    public void setFrequencyList(List<Pair<TimeInterval, Integer>> list) {
        this._frequencyList = list;
    }

    public void setPlatform(String str) {
        this._platform = str;
    }

    public void setTtStatus(int i) {
        this._ttStatus = i;
    }

    public void setTtStatusId(int i) {
        this._ttStatusId = i;
    }

    public void setTtType(int i) {
        this._ttType = i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("TripSummary{_tripId='");
        hj1.U0(i0, this._tripId, '\'', ", _arrivalTime=");
        i0.append(this._arrivalTime);
        i0.append(", _firstStop='");
        i0.append(this._firstStop);
        i0.append('\'');
        i0.append(", _lastStop='");
        i0.append(this._lastStop);
        i0.append('\'');
        i0.append(", _directionStop='");
        i0.append(this._directionStop);
        i0.append('\'');
        i0.append(", _routeId='");
        i0.append(this._routeId);
        i0.append('\'');
        i0.append('}');
        return i0.toString();
    }

    public TripSummary(String str, int i, Stop stop, Stop stop2, Stop stop3, String str2, String str3, boolean z, List<SPECIAL_FEATURE> list, String str4) {
        this._tripId = str;
        this._arrivalTime = i;
        this._firstStop = stop;
        this._lastStop = stop2;
        this._directionStop = stop3;
        this._routeId = str2;
        this._frequencyTrip = z;
        this._specialFeatures = list;
        this._routeName = str3;
        this._availabilityLevel = str4;
    }
}
