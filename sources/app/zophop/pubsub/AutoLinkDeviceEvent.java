package app.zophop.pubsub;

public class AutoLinkDeviceEvent {
    private String _errorMessage;
    private boolean _isAutoLinked;
    private final String _requestId;
    private final ad1 _responseType;

    public AutoLinkDeviceEvent(String str, String str2) {
        this._responseType = ad1.FAILED;
        this._requestId = str;
        this._errorMessage = str2;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public boolean isIsAutoLinked() {
        return this._isAutoLinked;
    }

    public AutoLinkDeviceEvent(String str, boolean z) {
        this._responseType = ad1.SUCCESS;
        this._requestId = str;
        this._isAutoLinked = z;
    }
}
