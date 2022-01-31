package app.zophop.models;

import android.location.Location;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class City {
    private final LatLngBounds _bounds;
    private String _busMapUrl;
    private final LatLng _cityCentre;
    private final String _cityImageUrl;
    private String _displayName;
    private final boolean _isBetaCity;
    private final boolean _isCityDiscontinued;
    private final List<LineMap> _lineMaps = new ArrayList();
    private final String _liveDataUrl;
    private int _liveRouteCount;
    private Map<TransitMode, List<Agency>> _modeAgencyMap;
    private Map<TransitMode, String> _modeUrlMap;
    private final List<TransitMode> _modes;
    private final String _name;
    private int _routeCount;
    private int _stopsCount;

    public static class LineMap {
        private final String _name;
        private final String _url;

        public LineMap(String str, String str2) {
            this._name = str;
            this._url = str2;
        }

        public String getName() {
            return this._name;
        }

        public String getUrl() {
            return this._url;
        }
    }

    public City(String str, String str2, LatLng latLng, LatLng latLng2, List<TransitMode> list, String str3, boolean z, boolean z2, LatLng latLng3) {
        this._name = str;
        this._cityImageUrl = str2;
        this._bounds = new LatLngBounds(latLng, latLng2);
        this._modes = list;
        this._liveDataUrl = str3;
        this._isBetaCity = z;
        this._isCityDiscontinued = z2;
        this._cityCentre = latLng3;
    }

    public void addLineMap(String str, String str2) {
        this._lineMaps.add(new LineMap(str, str2));
    }

    public boolean containsLocation(LatLng latLng) {
        return this._bounds.contains(latLng);
    }

    public LatLngBounds getBounds() {
        return this._bounds;
    }

    public String getBusMapUrl() {
        return this._busMapUrl;
    }

    public LatLng getCenter() {
        LatLng latLng = this._cityCentre;
        return latLng != null ? latLng : this._bounds.getCenter();
    }

    public String getCityImageUrl() {
        return this._cityImageUrl;
    }

    public String getDisplayName() {
        return this._displayName;
    }

    public List<LineMap> getLineMaps() {
        return this._lineMaps;
    }

    public String getLiveDataUrl() {
        return this._liveDataUrl;
    }

    public int getLiveRouteCount() {
        return this._liveRouteCount;
    }

    public Map<TransitMode, List<Agency>> getModeAgencyMap() {
        return this._modeAgencyMap;
    }

    public Map<TransitMode, String> getModePropertiesMap() {
        return this._modeUrlMap;
    }

    public List<TransitMode> getModes() {
        return this._modes;
    }

    public String getName() {
        return this._name;
    }

    public int getRadius() {
        LatLng center = getCenter();
        float[] fArr = new float[1];
        LatLng latLng = this._bounds.southwest;
        Location.distanceBetween(latLng.latitude, latLng.longitude, center.latitude, center.longitude, fArr);
        return (int) fArr[0];
    }

    public int getRouteCount() {
        return this._routeCount;
    }

    public int get_stopsCount() {
        return this._stopsCount;
    }

    public boolean isBetaCity() {
        return this._isBetaCity;
    }

    public boolean isCityDiscontinued() {
        return this._isCityDiscontinued;
    }

    public boolean isLiveFeedUrlForAgencyAvailable(TransitMode transitMode, String str) {
        Map<TransitMode, List<Agency>> map = this._modeAgencyMap;
        if (map == null) {
            return false;
        }
        for (Agency agency : map.get(transitMode)) {
            if (agency.getAgencyName().equals(str)) {
                return agency.isLiveFeedUrlAvailable();
            }
        }
        return false;
    }

    public void setBusMapUrl(String str) {
        this._busMapUrl = str;
    }

    public void setDisplayName(String str) {
        this._displayName = str;
    }

    public void setLiveRouteCount(int i) {
        this._liveRouteCount = i;
    }

    public void setModeAgencyMap(Map<TransitMode, List<Agency>> map) {
        this._modeAgencyMap = map;
    }

    public void setModePropertiesMap(Map<TransitMode, String> map) {
        this._modeUrlMap = map;
    }

    public void setRouteCount(int i) {
        this._routeCount = i;
    }

    public void setStopsCount(int i) {
        this._stopsCount = i;
    }
}
