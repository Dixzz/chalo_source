package app.zophop.pubsub.eventbus.events;

import app.zophop.models.UniversalSearchItem;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import java.util.List;

public class UniversalSearchResponseEvent {
    private String _errorMessage;
    private final List<UniversalSearchItem> _itemList;
    private long _queryTimeMillis;
    private String _requestId;
    private final TripPlannerEvent.ResponseType _responseType;
    private final String _searchQuery;

    public UniversalSearchResponseEvent(List<UniversalSearchItem> list, String str, TripPlannerEvent.ResponseType responseType) {
        this._itemList = list;
        this._searchQuery = str;
        setQueryTimeMillis(0);
        this._responseType = responseType;
    }

    public String getErrorMessage() {
        return this._errorMessage;
    }

    public List<UniversalSearchItem> getItemList() {
        return this._itemList;
    }

    public long getQueryTimeMillis() {
        return this._queryTimeMillis;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public TripPlannerEvent.ResponseType getResponseType() {
        return this._responseType;
    }

    public String getSearchQuery() {
        return this._searchQuery;
    }

    public void setErrorMessage(String str) {
        this._errorMessage = str;
    }

    public void setQueryTimeMillis(long j) {
        this._queryTimeMillis = j;
    }

    public UniversalSearchResponseEvent(List<UniversalSearchItem> list, String str, TripPlannerEvent.ResponseType responseType, String str2) {
        this._itemList = list;
        this._searchQuery = str;
        setQueryTimeMillis(0);
        this._responseType = responseType;
        this._requestId = str2;
    }
}
