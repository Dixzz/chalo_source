package app.zophop.models;

public class LastRideInfo {
    private long _activationDuration;
    private long _activationTimeStamp;
    private String _bookingId;
    private String _productType;

    public long getActivationDuration() {
        return this._activationDuration;
    }

    public long getActivationTimeStamp() {
        return this._activationTimeStamp;
    }

    public String getBookingId() {
        return this._bookingId;
    }

    public String getProductType() {
        return this._productType;
    }

    public void setActivationDuration(long j) {
        this._activationDuration = j;
    }

    public void setActivationTimeStamp(long j) {
        this._activationTimeStamp = j;
    }

    public void setBookingId(String str) {
        this._bookingId = str;
    }

    public void setProductType(String str) {
        this._productType = str;
    }
}
