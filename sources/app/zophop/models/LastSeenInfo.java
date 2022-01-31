package app.zophop.models;

public class LastSeenInfo {
    private long _lastSeen = 0;
    private String _vehicleNumber;

    public long getLastSeen() {
        return this._lastSeen;
    }

    public String getVehicleNumber() {
        return this._vehicleNumber;
    }

    public void setLastSeen(long j) {
        this._lastSeen = j;
    }

    public void setVehicleNumber(String str) {
        this._vehicleNumber = str;
    }
}
