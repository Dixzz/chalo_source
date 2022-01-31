package zophop.models;

public class SpatialRecord {
    private double distance;
    private Stop stop;

    public SpatialRecord(Stop stop2, double d) {
        this.distance = d;
        this.stop = stop2;
    }

    public double getDistance() {
        return this.distance;
    }

    public Stop getStop() {
        return this.stop;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public void setStop(Stop stop2) {
        this.stop = stop2;
    }
}
