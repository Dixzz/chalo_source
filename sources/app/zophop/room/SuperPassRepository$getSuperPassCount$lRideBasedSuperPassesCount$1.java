package app.zophop.room;

@y66(c = "app.zophop.room.SuperPassRepository$getSuperPassCount$lRideBasedSuperPassesCount$1", f = "SuperPassRepository.kt", l = {202}, m = "invokeSuspend")
/* compiled from: SuperPassRepository.kt */
public final class SuperPassRepository$getSuperPassCount$lRideBasedSuperPassesCount$1 extends b76 implements w76<mb6, k66<? super Integer>, Object> {
    public int label;
    public final /* synthetic */ SuperPassRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassRepository$getSuperPassCount$lRideBasedSuperPassesCount$1(SuperPassRepository superPassRepository, k66<? super SuperPassRepository$getSuperPassCount$lRideBasedSuperPassesCount$1> k66) {
        super(2, k66);
        this.this$0 = superPassRepository;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new SuperPassRepository$getSuperPassCount$lRideBasedSuperPassesCount$1(this.this$0, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super Integer> k66) {
        return ((SuperPassRepository$getSuperPassCount$lRideBasedSuperPassesCount$1) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            hd3.Y2(obj);
            SuperPassDao superPassDao = this.this$0.getSuperPassDao();
            String str = this.this$0.getCity();
            this.label = 1;
            obj = superPassDao.getRideBasedSuperPassCount(str, this);
            if (obj == p66) {
                return p66;
            }
        } else if (i == 1) {
            hd3.Y2(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
