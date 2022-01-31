package app.zophop.pubsub.eventbus.events;

import app.zophop.models.http_response.SummaryResponse;
import java.util.List;

public class StopSummaryEvent {
    private final ad1 _responseType;
    private final List<SummaryResponse> _summaryResponseList;

    public StopSummaryEvent(ad1 ad1, List<SummaryResponse> list) {
        this._responseType = ad1;
        this._summaryResponseList = list;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }

    public List<SummaryResponse> getSummaryResponseList() {
        return this._summaryResponseList;
    }
}
