package app.zophop.room;

import app.zophop.models.mTicketing.VisualValidationActivationDetails;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@y66(c = "app.zophop.room.VisualValidationRepository$deleteSelectActivationDetails$1", f = "VisualValidationRepository.kt", l = {43}, m = "invokeSuspend")
/* compiled from: VisualValidationRepository.kt */
public final class VisualValidationRepository$deleteSelectActivationDetails$1 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ List<VisualValidationActivationDetails> $lActivationDetailsList;
    public int label;
    public final /* synthetic */ VisualValidationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VisualValidationRepository$deleteSelectActivationDetails$1(List<VisualValidationActivationDetails> list, VisualValidationRepository visualValidationRepository, k66<? super VisualValidationRepository$deleteSelectActivationDetails$1> k66) {
        super(2, k66);
        this.$lActivationDetailsList = list;
        this.this$0 = visualValidationRepository;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new VisualValidationRepository$deleteSelectActivationDetails$1(this.$lActivationDetailsList, this.this$0, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((VisualValidationRepository$deleteSelectActivationDetails$1) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            hd3.Y2(obj);
            List<VisualValidationActivationDetails> list = this.$lActivationDetailsList;
            ArrayList arrayList = new ArrayList(hd3.I(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Long(it.next().getActivationTimeStamp()));
            }
            VisualValidationDao access$getVisualValidationDao = VisualValidationRepository.access$getVisualValidationDao(this.this$0);
            this.label = 1;
            if (access$getVisualValidationDao.deleteSelectActivationDetails(arrayList, this) == p66) {
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
