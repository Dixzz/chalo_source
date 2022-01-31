package app.zophop.pubsub.eventbus.events;

import app.zophop.models.TransitMode;
import app.zophop.models.http_response.SummaryResponse;
import java.util.List;

public class SummaryResponseEvent {
    private final TransitMode _mode;
    private final String _requestId;
    private final ResponseType _responseType;
    private final List<SummaryResponse> _summaryResponseList;

    public enum ResponseType {
        SUCCESS,
        GEOCODE_FAILED,
        QUERY_FAILED,
        NO_TRIPS,
        LOCATION_FAILED,
        NO_NEARBY_STOPS
    }

    public SummaryResponseEvent(String str, TransitMode transitMode, ResponseType responseType, List<SummaryResponse> list) {
        this._requestId = str;
        this._mode = transitMode;
        this._responseType = responseType;
        this._summaryResponseList = list;
    }

    public TransitMode getMode() {
        return this._mode;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public ResponseType getResponseType() {
        return this._responseType;
    }

    public List<SummaryResponse> getSummaryResponseList() {
        return this._summaryResponseList;
    }
}
