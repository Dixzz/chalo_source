package app.zophop.models.mTicketing.superPass;

import defpackage.ut;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RideBasedSuperPassValidationProperties.kt */
public final class RideBasedSuperPassValidationProperties extends SuperPassValidationProperties {
    private final int maxTripsPerDay;
    private final int numOfTrips;
    private final RideBasedSuperPassRideDetails superPassRideDetails;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RideBasedSuperPassValidationProperties(SuperPassStatus superPassStatus, long j, long j2, long j3, int i, int i2, RideBasedSuperPassRideDetails rideBasedSuperPassRideDetails) {
        super(superPassStatus, j, j2, j3, rideBasedSuperPassRideDetails);
        n86.e(superPassStatus, "status");
        n86.e(rideBasedSuperPassRideDetails, "superPassRideDetails");
        this.maxTripsPerDay = i;
        this.numOfTrips = i2;
        this.superPassRideDetails = rideBasedSuperPassRideDetails;
    }

    public final int getMaxTripsPerDay() {
        return this.maxTripsPerDay;
    }

    public final int getNumOfTrips() {
        return this.numOfTrips;
    }

    public final long getTimeAtWhichRideWillGetReclaimed(String str) {
        n86.e(str, "lCityName");
        long oldestHistoryCallTimeStamp = getSuperPassRideDetails().getOldestHistoryCallTimeStamp();
        n86.e(str, "lCityName");
        String lowerCase = str.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        ut.a aVar = ut.f3552a;
        String f = xt.f3961a.t().f("cityWiseRBSPReclaimTimeProd");
        long j = 86400000;
        if (f != null) {
            try {
                JSONObject jSONObject = new JSONObject(f);
                j = jSONObject.has(lowerCase) ? jSONObject.getLong(lowerCase) : jSONObject.has("all") ? jSONObject.getLong("all") : 86400000;
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                hj1.X0(e, b00.a());
            }
        }
        return oldestHistoryCallTimeStamp + j;
    }

    public final boolean shouldReclaim(String str) {
        n86.e(str, "lCityName");
        return !getSuperPassRideDetails().isActivationAllowedInCurrentSession() && !getSuperPassRideDetails().isOldestHistoryCallTimeStampExpired(str);
    }

    @Override // app.zophop.models.mTicketing.superPass.SuperPassValidationProperties
    public RideBasedSuperPassRideDetails getSuperPassRideDetails() {
        return this.superPassRideDetails;
    }
}
