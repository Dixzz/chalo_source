package zophop.models;

import java.io.Serializable;

public class Bound implements Serializable {
    private static final long serialVersionUID = 1;
    public double lat1;
    public double lat2;
    public double lon1;
    public double lon2;

    public boolean insideBound(double d, double d2) {
        return d <= this.lat2 && d >= this.lat1 && d2 <= this.lon2 && d2 >= this.lon1;
    }
}
