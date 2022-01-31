package app.zophop.models;

import android.util.Pair;
import java.util.List;
import zophop.models.SPECIAL_FEATURE;

public class Route extends RouteWithoutTimings {
    private final String _agencyName;
    private long _availabilityStatus;
    private final Stop _directionStop;
    private boolean _isDisrupted;
    private final boolean _isFreeRide;
    private boolean _isLive;
    private final boolean _isMticketingAvailable;
    private final boolean _isRoutePassEnabled;
    private final boolean _mTicketEnabled;
    private final String _polyline;
    private final List<RouteTiming> _routeTiming;
    private int _seatAvailability;
    private final List<SPECIAL_FEATURE> _special_features;
    private final List<String> _spfList;
    private int _ttStatus;
    private int _ttStatusId;

    public Route(String str, String str2, TransitMode transitMode, List<Stop> list, Stop stop, List<RouteTiming> list2, String str3, boolean z, boolean z2, boolean z3, boolean z4, String str4, List<SPECIAL_FEATURE> list3, List<String> list4) {
        super(str, str2, transitMode, list);
        this._directionStop = stop;
        this._routeTiming = list2;
        this._agencyName = str3;
        this._isMticketingAvailable = z;
        this._isLive = true;
        this._mTicketEnabled = z2;
        this._isRoutePassEnabled = z3;
        this._isFreeRide = z4;
        this._availabilityStatus = 2;
        this._isDisrupted = false;
        this._polyline = str4;
        this._spfList = list4;
        this._special_features = list3;
    }

    public String getAgencyName() {
        return this._agencyName;
    }

    public long getAvailabilityStatus() {
        return this._availabilityStatus;
    }

    public Stop getDirectionStop() {
        return this._directionStop;
    }

    public boolean getMticketingAvailablity() {
        return this._isMticketingAvailable;
    }

    public String getPolyline() {
        return this._polyline;
    }

    public List<RouteTiming> getRouteTiming() {
        return this._routeTiming;
    }

    public int getSeatAvailability() {
        return this._seatAvailability;
    }

    public int getTtStatus() {
        return this._ttStatus;
    }

    public int getTtStatusId() {
        return this._ttStatusId;
    }

    public List<SPECIAL_FEATURE> get_special_features() {
        return this._special_features;
    }

    public List<String> get_spfList() {
        return this._spfList;
    }

    public boolean isDisrupted() {
        return this._isDisrupted;
    }

    public boolean isFreeRide() {
        return this._isFreeRide;
    }

    public boolean isIsRoutePassEnabled() {
        return this._isRoutePassEnabled;
    }

    public boolean isLive() {
        return this._isLive;
    }

    public boolean isMTicketEnabled() {
        return this._mTicketEnabled;
    }

    public void setAvailabilityStatus(long j) {
        this._availabilityStatus = j;
    }

    public void setDisruption(boolean z) {
        this._isDisrupted = z;
    }

    public void setLive(boolean z) {
        this._isLive = z;
    }

    public void setSeatAvailability(int i) {
        this._seatAvailability = i;
    }

    public void setTtStatus(int i) {
        this._ttStatus = i;
    }

    public void setTtStatusId(int i) {
        this._ttStatusId = i;
    }

    public static class RouteTiming {
        public Pair<TimeInterval, Integer> _frequencyTuple;
        public final boolean _isFrequency = false;
        public int _startTime;
        public String _tripId;
        public int duration;

        public RouteTiming(int i, String str) {
            this._startTime = i;
            this.duration = -1;
            this._tripId = str;
        }

        public void setTripId(String str) {
            this._tripId = str;
        }

        public RouteTiming(Pair<TimeInterval, Integer> pair) {
            this._frequencyTuple = pair;
            this.duration = -1;
        }
    }

    public Route(RouteInfo routeInfo, List<Stop> list, Stop stop, List<RouteTiming> list2) {
        this(routeInfo.getRouteId(), routeInfo.getRouteName(), routeInfo.getTransitMode(), list, stop, list2, routeInfo.getAgencyName(), routeInfo.isMobileTicketing(), routeInfo.isMTicketEnabled(), routeInfo.isRoutePassEnabled(), routeInfo.isFreeRide(), routeInfo.getPolyline(), routeInfo.getSpecialFeatures(), routeInfo.get_updateSpecialFeaturesList());
        this._availabilityStatus = routeInfo.get_availabilityLevel();
        this._isDisrupted = routeInfo.is_isRouteDisrupted();
        this._seatAvailability = routeInfo.get_seatOccupancy();
    }
}
