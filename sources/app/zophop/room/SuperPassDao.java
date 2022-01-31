package app.zophop.room;

import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.superPass.MagicSuperPass;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPassRideDetailsRoom;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import java.util.List;

/* compiled from: SuperPassDao.kt */
public interface SuperPassDao {
    Object deleteAllMagicSuperPasses(k66<? super s56> k66);

    Object deleteAllMagicSuperPassesForCity(String str, k66<? super s56> k66);

    Object deleteAllPendingSuperPasses(String str, k66<? super s56> k66);

    Object deleteAllRideBasedSuperPasses(k66<? super s56> k66);

    Object deleteAllRideBasedSuperPassesForCity(String str, k66<? super s56> k66);

    Object deleteAllSuperPassApplications(k66<? super s56> k66);

    Object deleteAllSuperPassApplicationsForCity(String str, k66<? super s56> k66);

    Object doesMagicSuperPassExist(String str, k66<? super Boolean> k66);

    Object doesRideBasedSuperPassRideDetailsExist(String str, k66<? super Boolean> k66);

    LiveData<List<MagicSuperPass>> getAllMagicSuperPasses(String str);

    LiveData<List<PendingSuperPass>> getAllPendingSuperPass(String str);

    LiveData<List<RideBasedSuperPass>> getAllRideBasedSuperPasses(String str);

    LiveData<List<SuperPassApplication>> getAllSuperPassApplications(String str);

    qe6<MagicSuperPass> getMagicSuperPass(String str);

    Object getMagicSuperPassCount(String str, k66<? super Integer> k66);

    Object getMagicSuperPassLastActivationTimeStamp(String str, k66<? super Long> k66);

    qe6<PendingSuperPass> getPendingSuperPass(String str);

    LiveData<List<MagicSuperPass>> getRecentActiveMagicSuperPasses(String str, long j);

    LiveData<List<RideBasedSuperPass>> getRecentActiveRideBasedSuperPasses(String str, long j);

    qe6<RideBasedSuperPass> getRideBasedSuperPass(String str);

    Object getRideBasedSuperPassCount(String str, k66<? super Integer> k66);

    Object getRideBasedSuperPassRideDetails(String str, k66<? super RideBasedSuperPassRideDetailsRoom> k66);

    Object insertMagicSuperPass(MagicSuperPass magicSuperPass, k66<? super s56> k66);

    Object insertMagicSuperPassList(List<MagicSuperPass> list, k66<? super s56> k66);

    Object insertPendingSuperPassList(List<PendingSuperPass> list, k66<? super s56> k66);

    Object insertRideBasedSuperPass(RideBasedSuperPass rideBasedSuperPass, k66<? super s56> k66);

    Object insertRideBasedSuperPassList(List<RideBasedSuperPass> list, k66<? super s56> k66);

    Object insertRideBasedSuperPassRideDetails(RideBasedSuperPassRideDetailsRoom rideBasedSuperPassRideDetailsRoom, k66<? super s56> k66);

    Object insertSuperPassApplication(SuperPassApplication superPassApplication, k66<? super s56> k66);

    Object insertSuperPassApplicationsList(List<SuperPassApplication> list, k66<? super s56> k66);

    Object updateMagicSuperPassLastActivationTimeStamp(String str, long j, k66<? super s56> k66);

    Object updateRideBasedSuperPass(List<Long> list, long j, String str, k66<? super s56> k66);

    Object updateRideBasedSuperPassRideDetails(List<Long> list, boolean z, String str, long j, long j2, k66<? super s56> k66);
}
