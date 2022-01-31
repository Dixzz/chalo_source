package app.zophop.models.mTicketing;

import java.util.HashMap;
import java.util.Map;

public class BookingConfigurationMap {
    private Map<String, Map<String, BookingConfiguration>> _bookingConfigMap;

    public BookingConfigurationMap() {
        this._bookingConfigMap = new HashMap();
    }

    public void addConfiguration(String str, String str2, BookingConfiguration bookingConfiguration) {
        if (getBookingConfigMap() == null) {
            this._bookingConfigMap = new HashMap();
        }
        if (!getBookingConfigMap().containsKey(str)) {
            getBookingConfigMap().put(str, new HashMap());
        }
        getBookingConfigMap().get(str).put(str2, bookingConfiguration);
    }

    public Map<String, Map<String, BookingConfiguration>> getBookingConfigMap() {
        return this._bookingConfigMap;
    }

    public BookingConfiguration getBookingConfiguration(String str, String str2) {
        if (getBookingConfigMap() == null || !getBookingConfigMap().containsKey(str) || !getBookingConfigMap().get(str).containsKey(str2)) {
            return null;
        }
        return getBookingConfigMap().get(str).get(str2);
    }

    public void setBookingConfigMap(Map<String, Map<String, BookingConfiguration>> map) {
        this._bookingConfigMap = map;
    }

    public BookingConfigurationMap(Map<String, Map<String, BookingConfiguration>> map) {
        this._bookingConfigMap = map == null ? new HashMap<>() : map;
    }
}
