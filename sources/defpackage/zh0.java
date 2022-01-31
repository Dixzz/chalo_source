package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeHistoryActivity;
import java.util.List;

/* renamed from: zh0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class zh0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnlineCardRechargeHistoryActivity f4173a;

    public /* synthetic */ zh0(OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity) {
        this.f4173a = onlineCardRechargeHistoryActivity;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        OnlineCardRechargeHistoryActivity onlineCardRechargeHistoryActivity = this.f4173a;
        List list = (List) obj;
        int i = OnlineCardRechargeHistoryActivity.o;
        n86.e(onlineCardRechargeHistoryActivity, "this$0");
        if (xt.f3961a.L().m()) {
            if (!(list == null || list.isEmpty())) {
                RecyclerView recyclerView = ((dw) onlineCardRechargeHistoryActivity.f0()).b;
                n86.d(recyclerView, "viewBinding.cardPaymentsHistoryRecyclerView");
                recyclerView.setVisibility(0);
                ((yu) onlineCardRechargeHistoryActivity.m.getValue()).f2701a.b(list, null);
                rc6 rc6 = onlineCardRechargeHistoryActivity.l;
                if (rc6 != null) {
                    ec6.j(rc6, null, 1, null);
                }
                onlineCardRechargeHistoryActivity.x0();
            }
        }
    }
}
