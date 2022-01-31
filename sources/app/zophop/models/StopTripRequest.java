package app.zophop.models;

public class StopTripRequest extends TripRequest<Stop> {
    public StopTripRequest(Stop stop, Stop stop2, int i) {
        super(stop, stop2, i);
    }

    public String getDescription(Stop stop) {
        return stop.getName();
    }
}
