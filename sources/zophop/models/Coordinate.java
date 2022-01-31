package zophop.models;

import java.io.Serializable;

public class Coordinate implements Serializable {
    private static final long serialVersionUID = 1;
    public double lat;
    public double lon;

    public Coordinate() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate coordinate = (Coordinate) obj;
        if (coordinate.lat == this.lat && coordinate.lon == this.lon) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((int) ((this.lon * 31.0d) + (this.lat * 31.0d))) * 31;
    }

    public Coordinate(double d, double d2) {
        this.lat = d;
        this.lon = d2;
    }
}
