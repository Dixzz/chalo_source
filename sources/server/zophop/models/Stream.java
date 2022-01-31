package server.zophop.models;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Stream {
    private String _agency;
    private Boolean _arrivedAtStop;
    private String _city;
    private double _clat;
    private double _clon;
    private long _createdAt;
    private double _currentLegDistance;
    private long _currentLegTime;
    private String _destinationStopId;
    private String _fromStopName;
    private Halt _halt;
    private long _lastEtaRecorded;
    private long _lastEtaUpdated;
    private String _lastStopId;
    private long _lastUpdated;
    private int _lastValidStopIdIndex;
    private long _lastValidStopIdVisitTime;
    private Map _meta = null;
    private long _nextStopEta;
    private String _nextStopId;
    private String _operator;
    private StreamStatus _proximityStatus;
    private String _routeId;
    private String _routeName;
    private String _source;
    private String _sourceStopId;
    private String _stationType;
    private String _streamId;
    private AtomicReference<StreamStatus> _timeStatus = new AtomicReference<>();
    private String _toStopName;
    private String _userId;
    private boolean _verified;

    public Stream(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, long j) {
        this._streamId = str3;
        this._userId = str4;
        StreamStatus streamStatus = StreamStatus.OPEN;
        this._timeStatus = new AtomicReference<>(streamStatus);
        this._proximityStatus = streamStatus;
        this._city = str;
        this._routeId = str5;
        this._sourceStopId = str6;
        this._destinationStopId = str7;
        this._agency = str2;
        this._source = str8;
        this._createdAt = j;
    }

    public String getAgency() {
        return this._agency;
    }

    public boolean getArrivedAtStop() {
        return this._arrivedAtStop.booleanValue();
    }

    public String getCity() {
        return this._city;
    }

    public double getClat() {
        return this._clat;
    }

    public double getClon() {
        return this._clon;
    }

    public long getCreatedAt() {
        return this._createdAt;
    }

    public double getCurrentLegDistance() {
        return this._currentLegDistance;
    }

    public long getCurrentLegTime() {
        return this._currentLegTime;
    }

    public String getDestinationStopId() {
        return this._destinationStopId;
    }

    public String getFilteredUserId() {
        return this._userId.replace(" ", "").replace("-", "");
    }

    public String getFromStopName() {
        return this._fromStopName;
    }

    public Halt getHalt() {
        return this._halt;
    }

    public long getLastEtaRecorded() {
        return this._lastEtaRecorded;
    }

    public long getLastEtaUpdated() {
        return this._lastEtaUpdated;
    }

    public String getLastStopId() {
        return this._lastStopId;
    }

    public long getLastUpdated() {
        return this._lastUpdated;
    }

    public int getLastValidStopIdIndex() {
        return this._lastValidStopIdIndex;
    }

    public long getLastValidStopIdVisitTime() {
        return this._lastValidStopIdVisitTime;
    }

    public long getNextStopEta() {
        return this._nextStopEta;
    }

    public String getNextStopId() {
        return this._nextStopId;
    }

    public String getOperator() {
        return this._operator;
    }

    public StreamStatus getProxmityStatus() {
        return this._proximityStatus;
    }

    public String getRouteId() {
        return this._routeId;
    }

    public String getRouteName() {
        return this._routeName;
    }

    public String getSource() {
        return this._source;
    }

    public String getSourceStopId() {
        return this._sourceStopId;
    }

    public String getStationType() {
        return this._stationType;
    }

    public String getStreamId() {
        return this._streamId;
    }

    public StreamStatus getTimeStatus() {
        return this._timeStatus.get();
    }

    public String getToStopName() {
        return this._toStopName;
    }

    public String getUserId() {
        return this._userId;
    }

    public Map get_meta() {
        return this._meta;
    }

    public boolean hasHalt() {
        return this._halt != null;
    }

    public boolean isVerified() {
        return this._verified;
    }

    public void setArrivedAtStop(boolean z) {
        this._arrivedAtStop = Boolean.valueOf(z);
    }

    public void setClat(double d) {
        this._clat = d;
    }

    public void setClon(double d) {
        this._clon = d;
    }

    public void setCurrentLegDistance(double d) {
        this._currentLegDistance = d;
    }

    public void setCurrentLegTime(long j) {
        this._currentLegTime = j;
    }

    public void setDestinationStopId(String str) {
    }

    public void setFromStopName(String str) {
        this._fromStopName = str;
    }

    public void setHalt(Halt halt) {
        this._halt = halt;
    }

    public void setLastEtaRecorded(long j) {
        this._lastEtaRecorded = j;
    }

    public void setLastEtaUpdated(long j) {
        this._lastEtaUpdated = j;
    }

    public void setLastStopId(String str) {
        this._lastStopId = str;
    }

    public void setLastUpdated(long j) {
        this._lastUpdated = j;
    }

    public void setLastValidStopIdIndex(int i) {
        this._lastValidStopIdIndex = i;
    }

    public void setLastValidStopIdVisitTime(long j) {
        this._lastValidStopIdVisitTime = j;
    }

    public void setNextStopEta(long j) {
        this._nextStopEta = j;
    }

    public void setNextStopId(String str) {
        this._nextStopId = str;
    }

    public void setOperator(String str) {
        this._operator = str;
    }

    public void setProximityStatus(StreamStatus streamStatus) {
        this._proximityStatus = streamStatus;
    }

    public void setRouteName(String str) {
        this._routeName = str;
    }

    public void setStationType(String str) {
        this._stationType = str;
    }

    public void setTimeStatus(AtomicReference<StreamStatus> atomicReference) {
        this._timeStatus = atomicReference;
    }

    public void setToStopName(String str) {
        this._toStopName = str;
    }

    public void setVerified(boolean z) {
        this._verified = z;
    }

    public void set_meta(Map map) {
        this._meta = map;
    }

    public StreamStatus status() {
        StreamStatus streamStatus = this._proximityStatus;
        StreamStatus streamStatus2 = StreamStatus.OPEN;
        if (streamStatus.equals(streamStatus2) && this._timeStatus.get().equals(streamStatus2)) {
            return streamStatus2;
        }
        StreamStatus streamStatus3 = this._proximityStatus;
        StreamStatus streamStatus4 = StreamStatus.TERMINATED;
        if (!streamStatus3.equals(streamStatus4) && !this._timeStatus.get().equals(streamStatus4)) {
            StreamStatus streamStatus5 = this._proximityStatus;
            streamStatus4 = StreamStatus.CLOSED;
            if (!streamStatus5.equals(streamStatus4) && !this._timeStatus.get().equals(streamStatus4)) {
                StreamStatus streamStatus6 = this._proximityStatus;
                streamStatus4 = StreamStatus.WAITING;
                if (streamStatus6.equals(streamStatus4) || this._timeStatus.get().equals(streamStatus4)) {
                    return streamStatus4;
                }
                return null;
            }
        }
        return streamStatus4;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Stream{_userId='");
        hj1.U0(i0, this._userId, '\'', ", _streamId='");
        hj1.U0(i0, this._streamId, '\'', ", _verified=");
        i0.append(this._verified);
        i0.append(", _routeId='");
        hj1.U0(i0, this._routeId, '\'', ", _timeStatus=");
        i0.append(this._timeStatus);
        i0.append(", _proximityStatus=");
        i0.append(this._proximityStatus);
        i0.append(", _stationType='");
        hj1.U0(i0, this._stationType, '\'', ", _city='");
        hj1.U0(i0, this._city, '\'', ", _lastValidStopIdIndex=");
        i0.append(this._lastValidStopIdIndex);
        i0.append(", _lastValidStopIdVisitTime=");
        i0.append(this._lastValidStopIdVisitTime);
        i0.append(", _currentLegTime=");
        i0.append(this._currentLegTime);
        i0.append(", _currentLegDistance=");
        i0.append(this._currentLegDistance);
        i0.append(", _lastStopId='");
        hj1.U0(i0, this._lastStopId, '\'', ", _nextStopId='");
        hj1.U0(i0, this._nextStopId, '\'', ", _sourceStopId='");
        hj1.U0(i0, this._sourceStopId, '\'', ", _destinationStopId='");
        hj1.U0(i0, this._destinationStopId, '\'', ", _fromStopName='");
        hj1.U0(i0, this._fromStopName, '\'', ", _toStopName='");
        hj1.U0(i0, this._toStopName, '\'', ", _routeName='");
        hj1.U0(i0, this._routeName, '\'', ", _source='");
        hj1.U0(i0, this._source, '\'', ", _agency=");
        hj1.U0(i0, this._agency, '\'', ", operator=");
        i0.append(this._operator);
        i0.append('\'');
        i0.append('}');
        return i0.toString();
    }
}
