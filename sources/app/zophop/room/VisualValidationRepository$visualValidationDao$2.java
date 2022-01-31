package app.zophop.room;

/* compiled from: VisualValidationRepository.kt */
public final class VisualValidationRepository$visualValidationDao$2 extends o86 implements h76<VisualValidationDao> {
    public final /* synthetic */ VisualValidationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VisualValidationRepository$visualValidationDao$2(VisualValidationRepository visualValidationRepository) {
        super(0);
        this.this$0 = visualValidationRepository;
    }

    @Override // defpackage.h76
    public final VisualValidationDao invoke() {
        return AppDatabase.getDatabase(this.this$0.getContext()).getVisualValidationDao();
    }
}
