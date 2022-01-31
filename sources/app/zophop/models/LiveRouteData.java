package app.zophop.models;

import defpackage.mt0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveRouteData {
    private mt0.h _firebaseResponse;
    private Map<String, List<EtaUpdateInfo>> _liveFeedEtaUpdateInfoMap;
    private List<LocationUpdateInfo> _liveFeedLocationsList;
    private mt0.h _liveFeedResponse;
    private final Route _route;
    private final HashMap<String, StreamInfo> _streams = new HashMap<>();

    public LiveRouteData(Route route) {
        mt0.h hVar = mt0.h.WAITING;
        this._liveFeedResponse = hVar;
        this._firebaseResponse = hVar;
        this._liveFeedEtaUpdateInfoMap = new HashMap();
        this._liveFeedLocationsList = new ArrayList();
        this._route = route;
        if (isLiveFeedProvider()) {
            setLiveFeedResponse(hVar);
        }
    }

    private long getLiveFeedEtaUpdateTime() {
        long j = 0;
        for (Map.Entry<String, List<EtaUpdateInfo>> entry : this._liveFeedEtaUpdateInfoMap.entrySet()) {
            for (EtaUpdateInfo etaUpdateInfo : entry.getValue()) {
                long etaUpdateTimeInMillis = etaUpdateInfo.getEtaUpdateTimeInMillis();
                if (etaUpdateTimeInMillis > j) {
                    j = etaUpdateTimeInMillis;
                }
            }
        }
        return j;
    }

    public void addStreamInfo(StreamInfo streamInfo) {
        this._streams.put(streamInfo.getStreamId(), streamInfo);
    }

    public void clearStreams() {
        this._streams.clear();
    }

    public mt0.h getFirebaseResponse() {
        return this._firebaseResponse;
    }

    public List<StreamInfo> getFirebaseStreams() {
        return new ArrayList(this._streams.values());
    }

    public int getFirstLiveStopPosition() {
        int size = this._route.getStopSequence().size();
        for (StreamInfo streamInfo : this._streams.values()) {
            String nextStopId = streamInfo.getNextStopId();
            for (int i = 0; i < this._route.getStopSequence().size(); i++) {
                if (this._route.getStopSequence().get(i).getId().equals(nextStopId) && i < size) {
                    size = i;
                }
            }
        }
        return size;
    }

    public LastSeenInfo getLastSeenInfo() {
        LastSeenInfo lastSeenInfo = new LastSeenInfo();
        if (!isLiveFeedProvider()) {
            for (StreamInfo streamInfo : this._streams.values()) {
                if (lastSeenInfo.getLastSeen() < streamInfo.getTimeStamp()) {
                    lastSeenInfo.setLastSeen(streamInfo.getTimeStamp());
                    lastSeenInfo.setVehicleNumber(streamInfo.getVehicleNumber());
                }
            }
        } else {
            lastSeenInfo.setLastSeen(getLiveFeedEtaUpdateTime());
        }
        return lastSeenInfo;
    }

    public Map<String, List<EtaUpdateInfo>> getLiveFeedEtaUpdateInfoMap() {
        return this._liveFeedEtaUpdateInfoMap;
    }

    public List<LocationUpdateInfo> getLiveFeedLocationsList() {
        return this._liveFeedLocationsList;
    }

    public mt0.h getLiveFeedResponse() {
        return this._liveFeedResponse;
    }

    public StreamInfo getLiveStream(String str) {
        for (StreamInfo streamInfo : this._streams.values()) {
            if (streamInfo.getStreamId().equals(str)) {
                return streamInfo;
            }
        }
        return null;
    }

    public Route getRoute() {
        return this._route;
    }

    public int getStreamCount() {
        HashMap<String, StreamInfo> hashMap = this._streams;
        if (hashMap == null) {
            return 0;
        }
        return hashMap.size();
    }

    public boolean isLiveFeedProvider() {
        return xt.f3961a.k().d().isLiveFeedUrlForAgencyAvailable(this._route.getMode(), this._route.getAgencyName());
    }

    public void setFirebaseResponse(mt0.h hVar) {
        this._firebaseResponse = hVar;
    }

    public void setLiveFeedData(Map<String, List<EtaUpdateInfo>> map, List<LocationUpdateInfo> list) {
        this._liveFeedEtaUpdateInfoMap = map;
        this._liveFeedLocationsList = list;
    }

    public void setLiveFeedEtaUpdateInfoMap(Map<String, List<EtaUpdateInfo>> map) {
        this._liveFeedEtaUpdateInfoMap = map;
    }

    public void setLiveFeedResponse(mt0.h hVar) {
        this._liveFeedResponse = hVar;
    }

    public void addStreamInfo(DataInfo dataInfo) {
        StreamInfo streamInfo = (StreamInfo) dataInfo;
        this._streams.put(streamInfo.getStreamId(), streamInfo);
    }
}
