package app.zophop.pubsub.eventbus.events;

import app.zophop.models.StreamInfo;
import java.util.List;
import java.util.Map;

public class FirebaseRouteUpdateEvent {
    private String _requestId;
    private ad1 _responseType;
    private List<StreamInfo> _streamInfoList;
    private Map<String, StreamInfo> _streamInfoMap;

    public String get_requestId() {
        return this._requestId;
    }

    public ad1 get_responseType() {
        return this._responseType;
    }

    public List<StreamInfo> get_streamInfoList() {
        return this._streamInfoList;
    }

    public Map<String, StreamInfo> get_streamInfoMap() {
        return this._streamInfoMap;
    }

    public void setStreamInfoList(List<StreamInfo> list) {
        this._streamInfoList = list;
    }

    public void setStreamInfoMap(Map<String, StreamInfo> map) {
        this._streamInfoMap = map;
    }

    public void set_requestId(String str) {
        this._requestId = str;
    }

    public void set_responseType(ad1 ad1) {
        this._responseType = ad1;
    }
}
