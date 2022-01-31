package app.zophop.room;

import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.SuperPassJsonParser;
import java.util.List;
import org.json.JSONArray;

@y66(c = "app.zophop.room.SuperPassRepository$updateSuperPassApplicationTable$2", f = "SuperPassRepository.kt", l = {93, 94}, m = "invokeSuspend")
/* compiled from: SuperPassRepository.kt */
public final class SuperPassRepository$updateSuperPassApplicationTable$2 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ JSONArray $lApplicationsArray;
    public Object L$0;
    public int label;
    public final /* synthetic */ SuperPassRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassRepository$updateSuperPassApplicationTable$2(JSONArray jSONArray, SuperPassRepository superPassRepository, k66<? super SuperPassRepository$updateSuperPassApplicationTable$2> k66) {
        super(2, k66);
        this.$lApplicationsArray = jSONArray;
        this.this$0 = superPassRepository;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new SuperPassRepository$updateSuperPassApplicationTable$2(this.$lApplicationsArray, this.this$0, k66);
    }

    public final Object invoke(mb6 mb6, k66<? super s56> k66) {
        return ((SuperPassRepository$updateSuperPassApplicationTable$2) create(mb6, k66)).invokeSuspend(s56.f3190a);
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        List<SuperPassApplication> list;
        p66 p66 = p66.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            hd3.Y2(obj);
            list = SuperPassJsonParser.INSTANCE.parsePassApplicationsArray(this.$lApplicationsArray);
            SuperPassDao superPassDao = this.this$0.getSuperPassDao();
            String str = this.this$0.getCity();
            this.L$0 = list;
            this.label = 1;
            if (superPassDao.deleteAllSuperPassApplicationsForCity(str, this) == p66) {
                return p66;
            }
        } else if (i == 1) {
            list = (List) this.L$0;
            hd3.Y2(obj);
        } else if (i == 2) {
            hd3.Y2(obj);
            return s56.f3190a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SuperPassDao superPassDao2 = this.this$0.getSuperPassDao();
        this.L$0 = null;
        this.label = 2;
        if (superPassDao2.insertSuperPassApplicationsList(list, this) == p66) {
            return p66;
        }
        return s56.f3190a;
    }
}
