package app.zophop.models;

public class LocationTripRequest extends TripRequest<mf1> {
    public LocationTripRequest(mf1 mf1, mf1 mf12, int i) {
        super(mf1, mf12, i);
    }

    public String getDescription(mf1 mf1) {
        return mf1.c;
    }
}
