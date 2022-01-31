package app.zophop.pubsub.eventbus.events;

import app.zophop.models.CityAvailability;

public class DisruptionEvent {
    public final CityAvailability _cityAvailability;
    public boolean initialFetch;
    public ad1 responseType;

    public DisruptionEvent(CityAvailability cityAvailability) {
        this._cityAvailability = cityAvailability;
    }

    public CityAvailability getCityAvailability() {
        return this._cityAvailability;
    }

    public ad1 getResponseType() {
        return this.responseType;
    }

    public boolean isInitialFetch() {
        return this.initialFetch;
    }

    public void setInitialFetch(boolean z) {
        this.initialFetch = z;
    }

    public void setResponseType(ad1 ad1) {
        this.responseType = ad1;
    }
}
