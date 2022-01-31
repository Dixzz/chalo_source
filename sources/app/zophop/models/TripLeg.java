package app.zophop.models;

public class TripLeg {
    private final int _arrivalTime;
    private String _platform;
    private final Stop _stop;

    public TripLeg(Stop stop, int i) {
        this._stop = stop;
        this._arrivalTime = i;
    }

    public int getArrivalTime() {
        return this._arrivalTime;
    }

    public String getPlatform() {
        return this._platform;
    }

    public Stop getStop() {
        return this._stop;
    }

    public void setPlatform(String str) {
        this._platform = str;
    }
}
