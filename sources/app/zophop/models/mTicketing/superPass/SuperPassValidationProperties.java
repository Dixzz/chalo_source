package app.zophop.models.mTicketing.superPass;

/* compiled from: SuperPassValidationProperties.kt */
public class SuperPassValidationProperties {
    private final long activeDuration;
    private final long expiryTime;
    private final long startTime;
    private final SuperPassStatus status;
    private final SuperPassRideDetails superPassRideDetails;

    public SuperPassValidationProperties(SuperPassStatus superPassStatus, long j, long j2, long j3, SuperPassRideDetails superPassRideDetails2) {
        n86.e(superPassStatus, "status");
        n86.e(superPassRideDetails2, "superPassRideDetails");
        this.status = superPassStatus;
        this.startTime = j;
        this.expiryTime = j2;
        this.activeDuration = j3;
        this.superPassRideDetails = superPassRideDetails2;
    }

    public final long getActiveDuration() {
        return this.activeDuration;
    }

    public final long getExpiryTime() {
        return this.expiryTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final SuperPassStatus getStatus() {
        return this.status;
    }

    public SuperPassRideDetails getSuperPassRideDetails() {
        return this.superPassRideDetails;
    }
}
