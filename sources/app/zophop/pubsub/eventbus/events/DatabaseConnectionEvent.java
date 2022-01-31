package app.zophop.pubsub.eventbus.events;

public class DatabaseConnectionEvent {
    public boolean isConnected;

    public boolean isConnected() {
        return this.isConnected;
    }

    public void setConnected(boolean z) {
        this.isConnected = z;
    }
}
