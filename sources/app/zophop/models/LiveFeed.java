package app.zophop.models;

import java.util.List;
import java.util.Map;

public class LiveFeed {
    private final List<LocationUpdateInfo> _locationInfoList;
    private final Map<String, List<EtaUpdateInfo>> _stopEtaInfoMap;

    public LiveFeed(boolean z, Map<String, List<EtaUpdateInfo>> map, List<LocationUpdateInfo> list) {
        this._stopEtaInfoMap = map;
        this._locationInfoList = list;
    }

    public Map<String, List<EtaUpdateInfo>> getEtaUpdateInfoMap() {
        return this._stopEtaInfoMap;
    }

    public List<LocationUpdateInfo> getLocationInfoList() {
        return this._locationInfoList;
    }
}
