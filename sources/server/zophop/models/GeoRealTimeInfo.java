package server.zophop.models;

public class GeoRealTimeInfo extends RealTimeRouteInfo {
    private String _streamId;

    public GeoRealTimeInfo(RealTimeRouteInfo realTimeRouteInfo, String str, String str2) {
        super(realTimeRouteInfo.getRouteId(), realTimeRouteInfo.getRouteName(), realTimeRouteInfo.getFromName(), realTimeRouteInfo.getToName(), realTimeRouteInfo.getMode(), realTimeRouteInfo.getAgencyName(), str2);
        this._streamId = str;
    }

    public String getStreamId() {
        return this._streamId;
    }
}
