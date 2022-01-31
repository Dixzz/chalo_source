package app.zophop.models.mTicketing.superPass;

import defpackage.ut;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RideBasedSuperPassRideDetails.kt */
public class RideBasedSuperPassRideDetails extends SuperPassRideDetails {
    public static final Companion Companion = new Companion(null);
    private final boolean isActivationAllowedInCurrentSession;
    private final long oldestHistoryCallTimeStamp;
    private List<Long> previousRideTimeStamps;

    /* compiled from: RideBasedSuperPassRideDetails.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }

        public final RideBasedSuperPassRideDetails getRideBasedSuperPassRideDetailsForFreshPurchase() {
            return new RideBasedSuperPassRideDetails(new ArrayList(), true, ui1.Q(), -1, -1);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RideBasedSuperPassRideDetails(List<Long> list, boolean z, long j, long j2, long j3) {
        super(j2, j3);
        n86.e(list, "previousRideTimeStamps");
        this.previousRideTimeStamps = list;
        this.isActivationAllowedInCurrentSession = z;
        this.oldestHistoryCallTimeStamp = j;
    }

    public final long getOldestHistoryCallTimeStamp() {
        return this.oldestHistoryCallTimeStamp;
    }

    public final List<Long> getPreviousRideTimeStamps() {
        return this.previousRideTimeStamps;
    }

    public final boolean isActivationAllowedInCurrentSession() {
        return this.isActivationAllowedInCurrentSession;
    }

    public final boolean isOldestHistoryCallTimeStampExpired(String str) {
        n86.e(str, "lCityName");
        long j = this.oldestHistoryCallTimeStamp;
        n86.e(str, "lCityName");
        String lowerCase = str.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        ut.a aVar = ut.f3552a;
        String f = xt.f3961a.t().f("cityWiseRBSPReclaimTimeProd");
        long j2 = 86400000;
        if (f != null) {
            try {
                JSONObject jSONObject = new JSONObject(f);
                j2 = jSONObject.has(lowerCase) ? jSONObject.getLong(lowerCase) : jSONObject.has("all") ? jSONObject.getLong("all") : 86400000;
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                hj1.X0(e, b00.a());
            }
        }
        return j + j2 < ui1.Q();
    }

    public final void setPreviousRideTimeStamps(List<Long> list) {
        n86.e(list, "<set-?>");
        this.previousRideTimeStamps = list;
    }
}
