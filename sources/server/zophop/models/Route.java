package server.zophop.models;

import com.google.maps.model.LatLng;
import java.util.List;
import server.zophop.utils.DistanceUtils;

public class Route {
    private String _agency;
    private String _firstStop;
    private String _id;
    private String _lastStop;
    private String _name;
    private String _polyline;
    private String _reverseRouteId;
    private List<String> _seq;
    private List<String> _specialFeatures;
    private String _stationType;

    public Route(String str, String str2, String str3, String str4, String str5, String str6, List<String> list, List<String> list2, String str7) {
        this._name = str2;
        this._id = str;
        this._firstStop = str3;
        this._lastStop = str4;
        this._agency = str5;
        this._stationType = str6;
        this._seq = list;
        this._specialFeatures = list2;
        this._reverseRouteId = str7;
    }

    public String getAgency() {
        return this._agency;
    }

    public String getFirstStop() {
        return this._firstStop;
    }

    public String getId() {
        return this._id;
    }

    public Integer getIndex(String str) {
        int i = 0;
        for (String str2 : this._seq) {
            if (str2.equalsIgnoreCase(str)) {
                return Integer.valueOf(i);
            }
            i++;
        }
        return null;
    }

    public String getLastStop() {
        return this._lastStop;
    }

    public String getName() {
        return this._name;
    }

    public int getNextStopIndex(String str, String str2) {
        for (int i = 1; i < getStopSequence().size(); i++) {
            if (getStop(i - 1).equals(str) && getStop(i).equals(str2)) {
                return i + 1;
            }
        }
        return getStopSequence().size();
    }

    public String getPoly() {
        return this._polyline;
    }

    public String getPolyline() {
        return this._polyline;
    }

    public Integer getPolylinePointIndex(LatLng latLng) {
        List<LatLng> polylinePointSequence = getPolylinePointSequence();
        for (int i = 0; i < polylinePointSequence.size(); i++) {
            if (polylinePointSequence.get(i).lat == latLng.lat && polylinePointSequence.get(i).lng == latLng.lng) {
                return Integer.valueOf(i);
            }
        }
        return -1;
    }

    public List<LatLng> getPolylinePointSequence() {
        if (hasPolyline()) {
            return DistanceUtils.getLatLngsFromPolyline(this._polyline);
        }
        return null;
    }

    public String getReverseRouteId() {
        return this._reverseRouteId;
    }

    public List<String> getSpecialFeatures() {
        return this._specialFeatures;
    }

    public String getStationType() {
        return this._stationType;
    }

    public String getStop(int i) {
        if (i < 0 || i >= getStopSequence().size()) {
            return null;
        }
        return getStopSequence().get(i);
    }

    public List<String> getStopSequence() {
        return this._seq;
    }

    public boolean hasPolyline() {
        return !this._polyline.equalsIgnoreCase("") && this._polyline != null;
    }

    public boolean hasReverseRouteId() {
        String str = this._reverseRouteId;
        return str != null && str.length() > 0;
    }

    public boolean isConsecutiveStops(String str, String str2) {
        for (int i = 1; i < getStopSequence().size(); i++) {
            if (getStop(i).equals(str2) && getStop(i - 1).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void setPolyline(String str) {
        this._polyline = str;
    }

    public void setStationType(String str) {
        this._stationType = str;
    }

    public Route(String str, String str2, String str3, String str4, String str5, String str6, List<String> list, List<String> list2, String str7, String str8) {
        this._name = str2;
        this._id = str;
        this._firstStop = str3;
        this._lastStop = str4;
        this._agency = str5;
        this._stationType = str6;
        this._seq = list;
        this._specialFeatures = list2;
        this._reverseRouteId = str7;
        this._polyline = str8;
    }
}
