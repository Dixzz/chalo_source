package app.zophop.pubsub.eventbus.events;

import app.zophop.models.mTicketing.BookingConfigurationMap;

public class ConfigurationsFetchedEvent {
    private BookingConfigurationMap _bookingConfigMap;
    private final String _configRequestId;
    private String _errorMessage;
    private ad1 _responseType;

    public ConfigurationsFetchedEvent(ad1 ad1, String str, BookingConfigurationMap bookingConfigurationMap, String str2) {
        this._responseType = ad1;
        this._errorMessage = str;
        this._bookingConfigMap = bookingConfigurationMap;
        this._configRequestId = str2;
    }

    public BookingConfigurationMap getBookingConfigMap() {
        return this._bookingConfigMap;
    }

    public String getConfigRequestId() {
        return this._configRequestId;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public void setBookingConfigMap(BookingConfigurationMap bookingConfigurationMap) {
        this._bookingConfigMap = bookingConfigurationMap;
    }

    public void setErrorMessage(String str) {
        this._errorMessage = str;
    }

    public void setResponseType(ad1 ad1) {
        this._responseType = ad1;
    }
}
