package app.zophop.pubsub.eventbus.events;

public class UpdateTimeoutEvent {
    private String _qrCode;
    private ad1 _responseType;
    private String _tone;

    public UpdateTimeoutEvent(ad1 ad1) {
        this._responseType = ad1;
    }

    public String get_qrCode() {
        return this._qrCode;
    }

    public ad1 get_responseType() {
        return this._responseType;
    }

    public String get_tone() {
        return this._tone;
    }

    public void set_qrCode(String str) {
        this._qrCode = str;
    }

    public void set_responseType(ad1 ad1) {
        this._responseType = ad1;
    }

    public void set_tone(String str) {
        this._tone = str;
    }
}
