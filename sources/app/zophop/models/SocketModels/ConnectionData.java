package app.zophop.models.SocketModels;

import java.util.HashMap;
import java.util.Map;

public class ConnectionData {
    private final String baseUrl;
    private final boolean forceConnection;
    private final String path;
    private Map<String, PollingInfo> pollingInfoMap = new HashMap();
    private final double randomizationFactor;
    private final long reconnectionDelay;
    private final long reconnectionDelayMax;
    private long timeout;
    private String[] transports;

    public ConnectionData(long j, long j2, double d, String str, String str2, boolean z) {
        this.reconnectionDelay = j;
        this.reconnectionDelayMax = j2;
        this.randomizationFactor = d;
        this.baseUrl = str;
        this.path = str2;
        this.forceConnection = z;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getPath() {
        return this.path;
    }

    public Map<String, PollingInfo> getPollingInfoMap() {
        return this.pollingInfoMap;
    }

    public double getRandomizationFactor() {
        return this.randomizationFactor;
    }

    public long getReconnectionDelay() {
        return this.reconnectionDelay;
    }

    public long getReconnectionDelayMax() {
        return this.reconnectionDelayMax;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public String[] getTransports() {
        return this.transports;
    }

    public boolean isForceConnection() {
        return this.forceConnection;
    }

    public void setPollingInfoMap(Map<String, PollingInfo> map) {
        this.pollingInfoMap = map;
    }

    public void setTimeout(long j) {
        this.timeout = j;
    }

    public void setTransports(String[] strArr) {
        this.transports = strArr;
    }
}
