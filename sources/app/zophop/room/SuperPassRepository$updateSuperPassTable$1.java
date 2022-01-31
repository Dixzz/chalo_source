package app.zophop.room;

@y66(c = "app.zophop.room.SuperPassRepository$updateSuperPassTable$1", f = "SuperPassRepository.kt", l = {104, 105}, m = "invokeSuspend")
/* compiled from: SuperPassRepository.kt */
public final class SuperPassRepository$updateSuperPassTable$1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public int label;
    public final /* synthetic */ SuperPassRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassRepository$updateSuperPassTable$1(SuperPassRepository superPassRepository, k66<? super SuperPassRepository$updateSuperPassTable$1> k66) {
        super(2, k66);
        this.this$0 = superPassRepository;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new SuperPassRepository$updateSuperPassTable$1(this.this$0, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((SuperPassRepository$updateSuperPassTable$1) create(mb6, k66)).invokeSuspend(s56.f3190a);
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
            if (superPassDao.deleteAllMagicSuperPassesForCity(str, this) == p66) {
                return p66;
            }
        } else if (i == 1) {
            hd3.Y2(obj);
        } else if (i == 2) {
            hd3.Y2(obj);
            return s56.f3190a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SuperPassDao superPassDao2 = this.this$0.getSuperPassDao();
        String str2 = this.this$0.getCity();
        this.label = 2;
        if (superPassDao2.deleteAllRideBasedSuperPassesForCity(str2, this) == p66) {
            return p66;
        }
        return s56.f3190a;
    }
}
