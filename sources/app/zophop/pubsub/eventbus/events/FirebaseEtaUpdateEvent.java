package app.zophop.pubsub.eventbus.events;

import app.zophop.models.DataInfo;
import java.util.List;

public class FirebaseEtaUpdateEvent {
    private List<DataInfo> _etaInfoList;
    private String _requestId;
    private ad1 _responseType;

    public List<DataInfo> get_etaInfoList() {
        return this._etaInfoList;
    }

    public String get_requestId() {
        return this._requestId;
    }

    public ad1 get_responseType() {
        return this._responseType;
    }

    public void set_etaInfoList(List<DataInfo> list) {
        this._etaInfoList = list;
    }

    public void set_requestId(String str) {
        this._requestId = str;
    }

    public void set_responseType(ad1 ad1) {
        this._responseType = ad1;
    }
}
