package app.zophop.models.mTicketing.superPass;

/* compiled from: SuperPassRideDetails.kt */
public class SuperPassRideDetails {
    private long lastActivationTimeStamp;
    private long lastPunchTimeStamp;

    public SuperPassRideDetails() {
        this(0, 0, 3, null);
    }

    public SuperPassRideDetails(long j, long j2) {
        this.lastActivationTimeStamp = j;
        this.lastPunchTimeStamp = j2;
    }

    public final long getLastActivationTimeStamp() {
        return this.lastActivationTimeStamp;
    }

    public final long getLastPunchTimeStamp() {
        return this.lastPunchTimeStamp;
    }

    public final void setLastActivationTimeStamp(long j) {
        this.lastActivationTimeStamp = j;
    }

    public final void setLastPunchTimeStamp(long j) {
        this.lastPunchTimeStamp = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuperPassRideDetails(long j, long j2, int i, j86 j86) {
        this((i & 1) != 0 ? -1 : j, (i & 2) != 0 ? -1 : j2);
    }
}
