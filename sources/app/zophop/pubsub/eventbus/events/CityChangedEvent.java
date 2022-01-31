package app.zophop.pubsub.eventbus.events;

import app.zophop.models.City;

public class CityChangedEvent {
    public final City _city;

    public CityChangedEvent(City city) {
        this._city = city;
    }
}
