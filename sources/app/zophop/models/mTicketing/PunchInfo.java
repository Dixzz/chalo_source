package app.zophop.models.mTicketing;

public class PunchInfo implements Comparable {
    private final PunchDirection _punchDirection;
    private final long _punchingTime;

    public enum PunchDirection {
        UP,
        DOWN,
        NEUTRAL
    }

    public PunchInfo(long j, PunchDirection punchDirection) {
        this._punchDirection = punchDirection;
        this._punchingTime = j;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof PunchInfo)) {
            return -1;
        }
        PunchInfo punchInfo = (PunchInfo) obj;
        if (getPunchingTime() < punchInfo.getPunchingTime()) {
            return -1;
        }
        return getPunchingTime() == punchInfo.getPunchingTime() ? 0 : 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PunchInfo punchInfo = (PunchInfo) obj;
        if (this._punchingTime == punchInfo._punchingTime && this._punchDirection == punchInfo._punchDirection) {
            return true;
        }
        return false;
    }

    public PunchDirection getPunchDirection() {
        return this._punchDirection;
    }

    public long getPunchingTime() {
        return this._punchingTime;
    }

    public int hashCode() {
        PunchDirection punchDirection = this._punchDirection;
        int hashCode = punchDirection != null ? punchDirection.hashCode() : 0;
        long j = this._punchingTime;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
