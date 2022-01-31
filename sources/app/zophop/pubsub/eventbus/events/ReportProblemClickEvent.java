package app.zophop.pubsub.eventbus.events;

public class ReportProblemClickEvent {
    private final String _requestId;

    public ReportProblemClickEvent(String str) {
        this._requestId = str;
    }

    public String getRequestId() {
        return this._requestId;
    }
}
