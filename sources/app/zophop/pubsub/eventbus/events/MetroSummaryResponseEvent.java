package app.zophop.pubsub.eventbus.events;

import app.zophop.models.TransitMode;
import app.zophop.models.http_response.SummaryResponse;
import app.zophop.pubsub.eventbus.events.SummaryResponseEvent;
import java.util.List;

public class MetroSummaryResponseEvent extends SummaryResponseEvent {
    public MetroSummaryResponseEvent(String str, SummaryResponseEvent.ResponseType responseType, List<SummaryResponse> list) {
        super(str, TransitMode.metro, responseType, list);
    }
}
