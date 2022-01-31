package app.zophop.models;

public class EtaUpdateInfo {
    private final int _etaInSeconds;
    private final long _etaUpdateTimeInMillis;

    public EtaUpdateInfo(int i, long j) {
        this._etaInSeconds = i;
        this._etaUpdateTimeInMillis = j;
    }

    public int getEtaInSeconds() {
        return this._etaInSeconds;
    }

    public long getEtaUpdateTimeInMillis() {
        return this._etaUpdateTimeInMillis;
    }
}
