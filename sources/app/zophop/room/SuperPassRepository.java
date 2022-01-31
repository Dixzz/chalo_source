package app.zophop.room;

import android.content.Context;
import androidx.lifecycle.LiveData;
import app.zophop.ZophopApplication;
import app.zophop.models.City;
import app.zophop.models.mTicketing.superPass.MagicSuperPass;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPassRideDetails;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPassRideDetailsRoom;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import com.razorpay.AnalyticsConstants;
import java.util.List;
import org.json.JSONArray;

/* compiled from: SuperPassRepository.kt */
public final class SuperPassRepository {
    private final j56 applicationContext$delegate = hd3.a2(new SuperPassRepository$applicationContext$2(this));
    private final Context context;
    private final j56 superPassDao$delegate = hd3.a2(new SuperPassRepository$superPassDao$2(this));

    public SuperPassRepository(Context context2) {
        n86.e(context2, AnalyticsConstants.CONTEXT);
        this.context = context2;
    }

    /* access modifiers changed from: private */
    public final Object deleteAllMagicSuperPasses(k66<? super s56> k66) {
        Object deleteAllMagicSuperPasses = getSuperPassDao().deleteAllMagicSuperPasses(k66);
        if (deleteAllMagicSuperPasses == p66.COROUTINE_SUSPENDED) {
            return deleteAllMagicSuperPasses;
        }
        return s56.f3190a;
    }

    /* access modifiers changed from: private */
    public final Object deleteAllRideBasedSuperPasses(k66<? super s56> k66) {
        Object deleteAllRideBasedSuperPasses = getSuperPassDao().deleteAllRideBasedSuperPasses(k66);
        if (deleteAllRideBasedSuperPasses == p66.COROUTINE_SUSPENDED) {
            return deleteAllRideBasedSuperPasses;
        }
        return s56.f3190a;
    }

    /* access modifiers changed from: private */
    public final Object deleteAllSuperPassApplications(k66<? super s56> k66) {
        Object deleteAllSuperPassApplications = getSuperPassDao().deleteAllSuperPassApplications(k66);
        if (deleteAllSuperPassApplications == p66.COROUTINE_SUSPENDED) {
            return deleteAllSuperPassApplications;
        }
        return s56.f3190a;
    }

    private final ZophopApplication getApplicationContext() {
        return (ZophopApplication) this.applicationContext$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getCity() {
        City d = xt.f3961a.k().d();
        n86.c(d);
        String name = d.getName();
        n86.d(name, "DependencyFactory.cityProvider.currentCity!!.name");
        String lowerCase = name.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    private final long getCurrentTime() {
        return ui1.Q();
    }

    /* access modifiers changed from: private */
    public final SuperPassDao getSuperPassDao() {
        return (SuperPassDao) this.superPassDao$delegate.getValue();
    }

    public final void createFreshEntryInRideBasedSuperPassRideDetailsRoomPostPurchase(String str) {
        n86.e(str, "lPassId");
        hd3.Y1((ZophopApplication) this.context, null, null, new SuperPassRepository$createFreshEntryInRideBasedSuperPassRideDetailsRoomPostPurchase$1(this, str, null), 3, null);
    }

    public final void deleteSuperPassProductData() {
        hd3.Y1(getApplicationContext(), null, null, new SuperPassRepository$deleteSuperPassProductData$1(this, null), 3, null);
    }

    public final Object doesMagicSuperPassExist(String str, k66<? super Boolean> k66) {
        return getSuperPassDao().doesMagicSuperPassExist(str, k66);
    }

    public final Object doesRideBasedSuperPassRideDetailsExist(String str, k66<? super Boolean> k66) {
        return getSuperPassDao().doesRideBasedSuperPassRideDetailsExist(str, k66);
    }

    public final LiveData<List<MagicSuperPass>> getAllMagicSuperPasses() {
        return getSuperPassDao().getAllMagicSuperPasses(getCity());
    }

    public final LiveData<List<PendingSuperPass>> getAllPendingSuperPasses() {
        return getSuperPassDao().getAllPendingSuperPass(getCity());
    }

    public final LiveData<List<RideBasedSuperPass>> getAllRideBasedSuperPasses() {
        return getSuperPassDao().getAllRideBasedSuperPasses(getCity());
    }

    public final LiveData<List<SuperPassApplication>> getAllSuperPassApplications() {
        return getSuperPassDao().getAllSuperPassApplications(getCity());
    }

    public final Context getContext() {
        return this.context;
    }

    public final qe6<MagicSuperPass> getMagicSuperPass(String str) {
        n86.e(str, "passId");
        return new ue6(getSuperPassDao().getMagicSuperPass(str));
    }

    public final Object getMagicSuperPassLastActivationTimeStamp(String str, k66<? super Long> k66) {
        return getSuperPassDao().getMagicSuperPassLastActivationTimeStamp(str, k66);
    }

    public final qe6<PendingSuperPass> getPendingSuperPass(String str) {
        n86.e(str, "passId");
        return new ue6(getSuperPassDao().getPendingSuperPass(str));
    }

    public final LiveData<List<MagicSuperPass>> getRecentActiveMagicSuperPasses() {
        return getSuperPassDao().getRecentActiveMagicSuperPasses(getCity(), getCurrentTime());
    }

    public final LiveData<List<RideBasedSuperPass>> getRecentActiveRideBasedSuperPasses() {
        return getSuperPassDao().getRecentActiveRideBasedSuperPasses(getCity(), getCurrentTime());
    }

    public final qe6<RideBasedSuperPass> getRideBasedSuperPass(String str) {
        n86.e(str, "passId");
        return new ue6(getSuperPassDao().getRideBasedSuperPass(str));
    }

    public final Object getRideBasedSuperPassRideDetails(String str, k66<? super RideBasedSuperPassRideDetails> k66) {
        return getSuperPassDao().getRideBasedSuperPassRideDetails(str, k66);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSuperPassCount(defpackage.k66<? super java.lang.Integer> r9) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassRepository.getSuperPassCount(k66):java.lang.Object");
    }

    public final void insertMagicSuperPass(MagicSuperPass magicSuperPass) {
        n86.e(magicSuperPass, "lMagicSuperPass");
        hd3.Y1((ZophopApplication) this.context, null, null, new SuperPassRepository$insertMagicSuperPass$1(this, magicSuperPass, null), 3, null);
    }

    public final void insertRideBasedSuperPass(RideBasedSuperPass rideBasedSuperPass) {
        n86.e(rideBasedSuperPass, "lRideBasedSuperPass");
        hd3.Y1((ZophopApplication) this.context, null, null, new SuperPassRepository$insertRideBasedSuperPass$1(this, rideBasedSuperPass, null), 3, null);
    }

    public final Object insertRideBasedSuperPassRideDetails(RideBasedSuperPassRideDetailsRoom rideBasedSuperPassRideDetailsRoom, k66<? super s56> k66) {
        Object insertRideBasedSuperPassRideDetails = getSuperPassDao().insertRideBasedSuperPassRideDetails(rideBasedSuperPassRideDetailsRoom, k66);
        if (insertRideBasedSuperPassRideDetails == p66.COROUTINE_SUSPENDED) {
            return insertRideBasedSuperPassRideDetails;
        }
        return s56.f3190a;
    }

    public final void insertSuperPassApplication(SuperPassApplication superPassApplication) {
        n86.e(superPassApplication, "lSuperPassApplication");
        hd3.Y1((ZophopApplication) this.context, null, null, new SuperPassRepository$insertSuperPassApplication$1(this, superPassApplication, null), 3, null);
    }

    public final void updateMagicSuperPassLastActivationTimeStamp(String str, long j) {
        n86.e(str, "passId");
        hd3.Y1(getApplicationContext(), null, null, new SuperPassRepository$updateMagicSuperPassLastActivationTimeStamp$1(this, str, j, null), 3, null);
    }

    public final void updatePendingSuperPassTable(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            hd3.Y1(getApplicationContext(), null, null, new SuperPassRepository$updatePendingSuperPassTable$1(this, null), 3, null);
        } else {
            hd3.Y1(getApplicationContext(), null, null, new SuperPassRepository$updatePendingSuperPassTable$2(this, jSONArray, null), 3, null);
        }
    }

    public final void updateRideBasedSuperPass(List<Long> list, long j, String str) {
        n86.e(list, "lRideTimeStamps");
        n86.e(str, "passId");
        hd3.Y1(getApplicationContext(), null, null, new SuperPassRepository$updateRideBasedSuperPass$1(this, list, j, str, null), 3, null);
    }

    public final void updateRideBasedSuperPassRideDetails(List<Long> list, boolean z, String str, long j, long j2) {
        n86.e(list, SuperPassJsonKeys.PUNCHES);
        n86.e(str, "passId");
        hd3.Y1(getApplicationContext(), null, null, new SuperPassRepository$updateRideBasedSuperPassRideDetails$1(this, list, z, str, j, j2, null), 3, null);
    }

    public final void updateSuperPassApplicationTable(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            hd3.Y1(getApplicationContext(), null, null, new SuperPassRepository$updateSuperPassApplicationTable$1(this, null), 3, null);
        } else {
            hd3.Y1(getApplicationContext(), null, null, new SuperPassRepository$updateSuperPassApplicationTable$2(jSONArray, this, null), 3, null);
        }
    }

    public final void updateSuperPassTable(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            hd3.Y1(getApplicationContext(), null, null, new SuperPassRepository$updateSuperPassTable$1(this, null), 3, null);
        } else {
            hd3.Y1(getApplicationContext(), null, null, new SuperPassRepository$updateSuperPassTable$2(jSONArray, this, null), 3, null);
        }
    }
}
