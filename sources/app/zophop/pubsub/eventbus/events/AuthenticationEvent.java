package app.zophop.pubsub.eventbus.events;

public class AuthenticationEvent {
    private String _source;
    private boolean _status;

    private boolean getStatus() {
        return this._status;
    }

    public String getSource() {
        return this._source;
    }

    public void setSource(String str) {
        this._source = str;
    }

    public void setStatus(boolean z) {
        this._status = z;
    }
}
