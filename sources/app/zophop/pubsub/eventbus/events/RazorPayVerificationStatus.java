package app.zophop.pubsub.eventbus.events;

public class RazorPayVerificationStatus {
    private final String _qrCode;
    private String _reason;
    private final ad1 _responseType;
    private String _tone;

    public RazorPayVerificationStatus(ad1 ad1, String str, String str2, String str3) {
        this._responseType = ad1;
        this._qrCode = str;
        this._reason = str2;
        this._tone = str3;
    }

    public String getQrCode() {
        return this._qrCode;
    }

    public String getReason() {
        return this._reason;
    }

    public String getTone() {
        return this._tone;
    }

    public ad1 get_responseType() {
        return this._responseType;
    }

    public void setReason(String str) {
        this._reason = str;
    }

    public void setTone(String str) {
        this._tone = str;
    }
}
