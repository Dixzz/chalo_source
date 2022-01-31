package app.zophop.models.mTicketing.superPass;

import android.text.format.DateUtils;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;

/* compiled from: RideBasedSuperPass.kt */
public final class RideBasedSuperPass extends SuperPass {
    private final RideBasedSuperPassUIProperties superPassUIProperties;
    private final RideBasedSuperPassValidationProperties superPassValidationProperties;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RideBasedSuperPass(SuperPassProperties superPassProperties, RideBasedSuperPassValidationProperties rideBasedSuperPassValidationProperties, RideBasedSuperPassUIProperties rideBasedSuperPassUIProperties, SuperPassRepurchaseProperties superPassRepurchaseProperties, SuperPassTransactionDetails superPassTransactionDetails) {
        super(superPassProperties, rideBasedSuperPassValidationProperties, rideBasedSuperPassUIProperties, superPassRepurchaseProperties, superPassTransactionDetails);
        n86.e(superPassProperties, "superPassProperties");
        n86.e(rideBasedSuperPassValidationProperties, "superPassValidationProperties");
        n86.e(rideBasedSuperPassUIProperties, "superPassUIProperties");
        n86.e(superPassRepurchaseProperties, "superPassRepurchaseProperties");
        n86.e(superPassTransactionDetails, "superPassTransactionDetails");
        this.superPassValidationProperties = rideBasedSuperPassValidationProperties;
        this.superPassUIProperties = rideBasedSuperPassUIProperties;
    }

    public final int getRemainingTotalTrips() {
        int numOfTrips = getSuperPassValidationProperties().getNumOfTrips();
        if (numOfTrips == -1) {
            return numOfTrips;
        }
        int size = numOfTrips - getSuperPassValidationProperties().getSuperPassRideDetails().getPreviousRideTimeStamps().size();
        if (size > 0) {
            return size;
        }
        return 0;
    }

    public final int getRemainingTripsForToday() {
        boolean z;
        int maxTripsPerDay = getSuperPassValidationProperties().getMaxTripsPerDay();
        if (maxTripsPerDay == -1) {
            return maxTripsPerDay;
        }
        for (Long l : getSuperPassValidationProperties().getSuperPassRideDetails().getPreviousRideTimeStamps()) {
            long longValue = l.longValue();
            long Q = ui1.Q();
            try {
                ZoneId of = ZoneId.of("Asia/Kolkata");
                LocalDateTime ofInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(longValue), of);
                LocalDateTime ofInstant2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(Q), of);
                z = ofInstant.getYear() == ofInstant2.getYear() && ofInstant.getMonthValue() == ofInstant2.getMonthValue() && ofInstant.getDayOfMonth() == ofInstant2.getDayOfMonth();
            } catch (Exception e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
                z = DateUtils.isToday(longValue);
            }
            if (z && maxTripsPerDay - 1 == 0) {
                break;
            }
        }
        return maxTripsPerDay;
    }

    public final boolean isRideAvailableToday() {
        int remainingTripsForToday = getRemainingTripsForToday();
        int remainingTotalTrips = getRemainingTotalTrips();
        return (remainingTotalTrips > 0 || remainingTotalTrips == -1) && (remainingTripsForToday > 0 || remainingTripsForToday == -1);
    }

    @Override // app.zophop.models.mTicketing.superPass.SuperPass
    public RideBasedSuperPassUIProperties getSuperPassUIProperties() {
        return this.superPassUIProperties;
    }

    @Override // app.zophop.models.mTicketing.superPass.SuperPass
    public RideBasedSuperPassValidationProperties getSuperPassValidationProperties() {
        return this.superPassValidationProperties;
    }
}
