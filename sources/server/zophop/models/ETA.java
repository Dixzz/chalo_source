package server.zophop.models;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ETA {
    public String _agency;
    public String _destination;
    public double _distance;
    public Integer _eta;
    public Integer _maxEta;
    public Integer _minEta;
    public String _routeName;
    public String _stopId;
    public Long _timeStamp;
    public String _vehicleNo;

    public ETA(int i, long j, String str, String str2, String str3, String str4, double d) {
        this._eta = Integer.valueOf(i);
        this._timeStamp = Long.valueOf(j);
        this._routeName = str;
        this._destination = str2;
        this._vehicleNo = str3;
        this._agency = str4;
        this._distance = d;
    }

    public String getRouteName() {
        return this._routeName;
    }

    public String getStopId() {
        return this._stopId;
    }

    public Map toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("_eta", this._eta);
        hashMap.put("_minEta", this._minEta);
        hashMap.put("_maxEta", this._maxEta);
        hashMap.put("_timeStamp", this._timeStamp);
        hashMap.put("_routeName", this._routeName);
        hashMap.put("_destination", this._destination);
        hashMap.put("_agency", this._agency);
        hashMap.put("_vehicleNo", this._vehicleNo);
        return hashMap;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_eta", this._eta);
        jSONObject.put("_minEta", this._minEta);
        jSONObject.put("_maxEta", this._maxEta);
        jSONObject.put("_timeStamp", this._timeStamp);
        jSONObject.put("_routeName", this._routeName);
        jSONObject.put("_destination", this._destination);
        jSONObject.put("_agency", this._agency);
        jSONObject.put("_vehicleNo", this._vehicleNo);
        jSONObject.put("_stopId", this._stopId);
        return jSONObject.toString();
    }

    public ETA(int i, int i2, long j, String str, String str2, String str3, String str4, double d) {
        this._eta = -1;
        this._minEta = Integer.valueOf(i);
        this._maxEta = Integer.valueOf(i2);
        this._timeStamp = Long.valueOf(j);
        this._routeName = str;
        this._destination = str2;
        this._vehicleNo = str3;
        this._agency = str4;
        this._distance = d;
    }

    public ETA(int i, long j, String str, String str2, String str3, String str4, double d, String str5) {
        this._stopId = str5;
        this._eta = Integer.valueOf(i);
        this._timeStamp = Long.valueOf(j);
        this._routeName = str;
        this._destination = str2;
        this._vehicleNo = str3;
        this._agency = str4;
        this._distance = d;
    }
}
