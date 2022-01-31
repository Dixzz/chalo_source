package app.zophop.pubsub.eventbus.events;

import app.zophop.models.TransitMode;
import app.zophop.models.http_response.SummaryResponse;
import app.zophop.pubsub.eventbus.events.SummaryResponseEvent;
import java.util.List;

public class MonorailSummaryResponseEvent extends SummaryResponseEvent {
    public MonorailSummaryResponseEvent(String str, SummaryResponseEvent.ResponseType responseType, List<SummaryResponse> list) {
        super(str, TransitMode.monorail, responseType, list);
    }
}
