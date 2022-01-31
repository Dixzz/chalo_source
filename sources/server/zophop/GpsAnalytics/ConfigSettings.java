package server.zophop.GpsAnalytics;

import java.util.Arrays;
import java.util.List;

public class ConfigSettings {
    private static final long INTERVAL = 24;
    private List<Agency> _agencies;
    private long _endTime;
    private long _frequency;
    private long _startTime;

    public ConfigSettings() {
        long currentTimeMillis = System.currentTimeMillis();
        this._endTime = currentTimeMillis;
        this._frequency = 24;
        this._startTime = currentTimeMillis - (((24 * 60) * 60) * 1000);
        this._agencies = Arrays.asList(Agency.values());
    }

    public long getEndTime() {
        return this._endTime;
    }

    public long getStartTime() {
        return this._startTime;
    }

    public ConfigSettings(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        this._endTime = currentTimeMillis;
        long j = (long) i;
        this._frequency = j;
        this._startTime = currentTimeMillis - ((j * 60) * 1000);
        this._agencies = Arrays.asList(Agency.values());
    }
}
