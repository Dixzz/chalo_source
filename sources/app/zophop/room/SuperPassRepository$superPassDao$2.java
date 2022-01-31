package app.zophop.room;

/* compiled from: SuperPassRepository.kt */
public final class SuperPassRepository$superPassDao$2 extends o86 implements h76<SuperPassDao> {
    public final /* synthetic */ SuperPassRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassRepository$superPassDao$2(SuperPassRepository superPassRepository) {
        super(0);
        this.this$0 = superPassRepository;
    }

    @Override // defpackage.h76
    public final SuperPassDao invoke() {
        return AppDatabase.getDatabase(this.this$0.getContext()).getSuperPassDao();
    }
}
