package app.zophop.models.autoCabBooking;

import app.zophop.models.AutoCabInfo;
import com.google.android.gms.maps.model.LatLng;

public class BookingDetails {
    private int _bearingDeg = 0;
    private BookingCode _code;
    private LatLng _currentLocation;
    private int _eta;
    private mf1 _fromLocation;
    private String _href;
    private long _lastUpdatedTime = 0;
    private String _productId;
    private String _productName;
    private final String _provider;
    private String _requestId;
    private double _surgeMultiple = 1.0d;
    private mf1 _toLocation;
    private BookingVehicleInfo _vehicleInfo;

    public BookingDetails(String str) {
        this._provider = str;
    }

    public int getBearing() {
        return this._bearingDeg;
    }

    public BookingCode getCode() {
        return this._code;
    }

    public LatLng getCurrentLocation() {
        return this._currentLocation;
    }

    public int getEta() {
        return this._eta;
    }

    public mf1 getFromLocation() {
        return this._fromLocation;
    }

    public String getHref() {
        return this._href;
    }

    public long getLastUpdatedTime() {
        return this._lastUpdatedTime;
    }

    public String getProductId() {
        return this._productId;
    }

    public String getProductName() {
        return this._productName;
    }

    public String getProvider() {
        return this._provider;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public double getSurgeMultiple() {
        return this._surgeMultiple;
    }

    public mf1 getToLocation() {
        return this._toLocation;
    }

    public BookingVehicleInfo getVehicleInfo() {
        return this._vehicleInfo;
    }

    public void setBearing(int i) {
        this._bearingDeg = i % 360;
    }

    public void setCode(BookingCode bookingCode) {
        this._code = bookingCode;
    }

    public void setCurrentLocation(LatLng latLng) {
        this._currentLocation = latLng;
    }

    public void setEta(int i) {
        this._eta = i;
    }

    public void setHref(String str) {
        this._href = str;
    }

    public void setLastUpdatedTime(long j) {
        this._lastUpdatedTime = j;
    }

    public void setRequestId(String str) {
        this._requestId = str;
    }

    public void setSurgeMultiple(double d) {
        this._surgeMultiple = d;
    }

    public void setToLocation(mf1 mf1) {
        this._toLocation = mf1;
    }

    public void setVehicleInfo(BookingVehicleInfo bookingVehicleInfo) {
        this._vehicleInfo = bookingVehicleInfo;
    }

    public BookingDetails(String str, mf1 mf1, mf1 mf12, AutoCabInfo autoCabInfo) {
        this._provider = str;
        this._fromLocation = mf1;
        this._toLocation = mf12;
        this._productId = autoCabInfo.getId();
        this._productName = autoCabInfo.getName();
    }

    public BookingDetails(String str, mf1 mf1, mf1 mf12, String str2, String str3) {
        this._provider = str;
        this._fromLocation = mf1;
        this._toLocation = mf12;
        this._productId = str2;
        this._productName = str3;
    }
}
