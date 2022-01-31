package app.zophop.room;

import java.util.List;

@y66(c = "app.zophop.room.SuperPassRepository$updateRideBasedSuperPassRideDetails$1", f = "SuperPassRepository.kt", l = {275}, m = "invokeSuspend")
/* compiled from: SuperPassRepository.kt */
public final class SuperPassRepository$updateRideBasedSuperPassRideDetails$1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ boolean $isActivationAllowedInCurrentSession;
    public final /* synthetic */ long $lActivationTimeStamp;
    public final /* synthetic */ long $lLastPunchTimeStamp;
    public final /* synthetic */ String $passId;
    public final /* synthetic */ List<Long> $punches;
    public int label;
    public final /* synthetic */ SuperPassRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassRepository$updateRideBasedSuperPassRideDetails$1(SuperPassRepository superPassRepository, List<Long> list, boolean z, String str, long j, long j2, k66<? super SuperPassRepository$updateRideBasedSuperPassRideDetails$1> k66) {
        super(2, k66);
        this.this$0 = superPassRepository;
        this.$punches = list;
        this.$isActivationAllowedInCurrentSession = z;
        this.$passId = str;
        this.$lActivationTimeStamp = j;
        this.$lLastPunchTimeStamp = j2;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new SuperPassRepository$updateRideBasedSuperPassRideDetails$1(this.this$0, this.$punches, this.$isActivationAllowedInCurrentSession, this.$passId, this.$lActivationTimeStamp, this.$lLastPunchTimeStamp, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((SuperPassRepository$updateRideBasedSuperPassRideDetails$1) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            hd3.Y2(obj);
            SuperPassDao superPassDao = this.this$0.getSuperPassDao();
            List<Long> list = this.$punches;
            boolean z = this.$isActivationAllowedInCurrentSession;
            String str = this.$passId;
            long j = this.$lActivationTimeStamp;
            long j2 = this.$lLastPunchTimeStamp;
            this.label = 1;
            if (superPassDao.updateRideBasedSuperPassRideDetails(list, z, str, j, j2, this) == p66) {
                return p66;
            }
        } else if (i == 1) {
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return s56.f3190a;
    }
}
