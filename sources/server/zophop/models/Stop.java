package server.zophop.models;

public class Stop {
    private String _id;
    private double _lat;
    private double _lon;
    private String _name;
    private String _stationType;

    public Stop(String str, String str2, String str3, double d, double d2) {
        this._name = str3;
        this._id = str;
        this._lat = d;
        this._lon = d2;
        this._stationType = str2;
    }

    public String getId() {
        return this._id;
    }

    public double getLat() {
        return this._lat;
    }

    public double getLon() {
        return this._lon;
    }

    public String getName() {
        return this._name;
    }

    public String getStationType() {
        return this._stationType;
    }

    public void setStationType(String str) {
        this._stationType = str;
    }
}
