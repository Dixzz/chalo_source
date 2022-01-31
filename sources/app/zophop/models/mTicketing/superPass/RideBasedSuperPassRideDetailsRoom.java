package app.zophop.models.mTicketing.superPass;

import java.util.List;

/* compiled from: RideBasedSuperPassRideDetailsRoom.kt */
public final class RideBasedSuperPassRideDetailsRoom extends RideBasedSuperPassRideDetails {
    private final String passId;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RideBasedSuperPassRideDetailsRoom(String str, List list, boolean z, long j, long j2, long j3, int i, j86 j86) {
        this((i & 1) != 0 ? new String() : str, list, z, j, j2, j3);
    }

    public final String getPassId() {
        return this.passId;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RideBasedSuperPassRideDetailsRoom(String str, List<Long> list, boolean z, long j, long j2, long j3) {
        super(list, z, j, j2, j3);
        n86.e(str, "passId");
        n86.e(list, "previousRideTimeStamps");
        this.passId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RideBasedSuperPassRideDetailsRoom(String str, RideBasedSuperPassRideDetails rideBasedSuperPassRideDetails) {
        this(str, rideBasedSuperPassRideDetails.getPreviousRideTimeStamps(), rideBasedSuperPassRideDetails.isActivationAllowedInCurrentSession(), rideBasedSuperPassRideDetails.getOldestHistoryCallTimeStamp(), rideBasedSuperPassRideDetails.getLastActivationTimeStamp(), rideBasedSuperPassRideDetails.getLastPunchTimeStamp());
        n86.e(str, "passId");
        n86.e(rideBasedSuperPassRideDetails, "rideBasedSuperPassRideDetails");
    }
}
