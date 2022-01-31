package app.zophop.models;

import defpackage.i10;

public class VehicleInfo {
    public i10.a _etaType;
    public String _stopId;
    public String routeId;
    public long timeStamp;
    public String vehicleNo;

    public VehicleInfo(String str, long j) {
        this.vehicleNo = str;
        this.timeStamp = j;
    }

    public i10.a getEtaType() {
        return this._etaType;
    }

    public String getRouteId() {
        return this.routeId;
    }

    public String getStopId() {
        return this._stopId;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String getVehicleNo() {
        return this.vehicleNo;
    }

    public void setEtaType(i10.a aVar) {
        this._etaType = aVar;
    }

    public void setRouteId(String str) {
        this.routeId = str;
    }

    public void setStopId(String str) {
        this._stopId = str;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public void setVehicleNo(String str) {
        this.vehicleNo = str;
    }
}
