package app.zophop.pubsub.eventbus.events;

import app.zophop.models.DataInfo;
import java.util.List;

public class StopListenerEvent {
    public final List<DataInfo> _dataInfo;
    public final String _stopId;

    public StopListenerEvent(String str, List<DataInfo> list) {
        this._stopId = str;
        this._dataInfo = list;
    }

    public List<DataInfo> get_dataInfo() {
        return this._dataInfo;
    }

    public String get_stopId() {
        return this._stopId;
    }
}
