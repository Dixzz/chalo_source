package app.zophop.pubsub.eventbus.events;

public class PreProcessingDoneEvent {
    private final ad1 responseType;

    public PreProcessingDoneEvent(ad1 ad1) {
        this.responseType = ad1;
    }

    public ad1 getResponseType() {
        return this.responseType;
    }
}
