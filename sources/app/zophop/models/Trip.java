package app.zophop.models;

import java.util.List;
import zophop.models.SPECIAL_FEATURE;

public class Trip {
    private final boolean _isFrequencyTrip;
    private String _routeId;
    private final List<SPECIAL_FEATURE> _specialFeatures;
    private final TransitMode _transitMode;
    private final String _tripId;
    private final List<TripLeg> _tripLegs;

    public Trip(String str, TransitMode transitMode, List<TripLeg> list, List<SPECIAL_FEATURE> list2) {
        this._tripId = str;
        this._transitMode = transitMode;
        this._tripLegs = list;
        this._isFrequencyTrip = false;
        this._specialFeatures = list2;
    }

    public List<SPECIAL_FEATURE> getSpecialFeatures() {
        return this._specialFeatures;
    }

    public TransitMode getTransitMode() {
        return this._transitMode;
    }

    public String getTripId() {
        return this._tripId;
    }

    public List<TripLeg> getTripLegs() {
        return this._tripLegs;
    }

    public String get_routeId() {
        return this._routeId;
    }

    public boolean isFrequencyTrip() {
        return this._isFrequencyTrip;
    }

    public void set_routeId(String str) {
        this._routeId = str;
    }

    public Trip(String str, TransitMode transitMode, List<TripLeg> list, boolean z, List<SPECIAL_FEATURE> list2) {
        this._tripId = str;
        this._transitMode = transitMode;
        this._tripLegs = list;
        this._isFrequencyTrip = z;
        this._specialFeatures = list2;
    }
}
