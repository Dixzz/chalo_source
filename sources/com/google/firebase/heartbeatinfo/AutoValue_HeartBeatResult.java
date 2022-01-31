package com.google.firebase.heartbeatinfo;

import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import java.util.Objects;

public final class AutoValue_HeartBeatResult extends HeartBeatResult {
    private final HeartBeatInfo.HeartBeat heartBeat;
    private final long millis;
    private final String sdkName;

    public AutoValue_HeartBeatResult(String str, long j, HeartBeatInfo.HeartBeat heartBeat2) {
        Objects.requireNonNull(str, "Null sdkName");
        this.sdkName = str;
        this.millis = j;
        Objects.requireNonNull(heartBeat2, "Null heartBeat");
        this.heartBeat = heartBeat2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeartBeatResult)) {
            return false;
        }
        HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
        if (!this.sdkName.equals(heartBeatResult.getSdkName()) || this.millis != heartBeatResult.getMillis() || !this.heartBeat.equals(heartBeatResult.getHeartBeat())) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public HeartBeatInfo.HeartBeat getHeartBeat() {
        return this.heartBeat;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public long getMillis() {
        return this.millis;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public String getSdkName() {
        return this.sdkName;
    }

    public int hashCode() {
        long j = this.millis;
        return ((((this.sdkName.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.heartBeat.hashCode();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("HeartBeatResult{sdkName=");
        i0.append(this.sdkName);
        i0.append(", millis=");
        i0.append(this.millis);
        i0.append(", heartBeat=");
        i0.append(this.heartBeat);
        i0.append("}");
        return i0.toString();
    }
}
