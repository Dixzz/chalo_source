package app.zophop.models.http_response;

import app.zophop.models.Stop;
import java.util.List;

public class SummaryResponse {
    private final double _distance;
    private final Stop _stop;
    private final List<TripSummary> _tripSummaryList;

    public SummaryResponse(Stop stop, double d, List<TripSummary> list) {
        this._stop = stop;
        this._distance = d;
        this._tripSummaryList = list;
    }

    public double getDistance() {
        return this._distance;
    }

    public Stop getStop() {
        return this._stop;
    }

    public List<TripSummary> getTripSummary() {
        return this._tripSummaryList;
    }
}
