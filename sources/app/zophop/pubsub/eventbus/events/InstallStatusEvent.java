package app.zophop.pubsub.eventbus.events;

public class InstallStatusEvent {
    private final String _installType;

    public InstallStatusEvent(String str) {
        this._installType = str;
    }

    public String installType() {
        return this._installType;
    }
}
