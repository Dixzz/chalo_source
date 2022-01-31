package defpackage;

import app.zophop.ui.fragments.superpassPurchase.ConfirmSuperPassPurchaseFragment;
import app.zophop.ui.viewmodels.superpassPurchase.SuperPassPurchaseSharedViewModel;

/* renamed from: v41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class v41 implements gm4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ em4 f3595a;
    public final /* synthetic */ ConfirmSuperPassPurchaseFragment b;

    public /* synthetic */ v41(em4 em4, ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment) {
        this.f3595a = em4;
        this.b = confirmSuperPassPurchaseFragment;
    }

    @Override // defpackage.gm4
    public final void a(Object obj) {
        em4 em4 = this.f3595a;
        ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment = this.b;
        Long l = (Long) obj;
        int i = ConfirmSuperPassPurchaseFragment.k;
        n86.e(em4, "$lMaterialDatePicker");
        n86.e(confirmSuperPassPurchaseFragment, "this$0");
        Long l2 = (Long) em4.e();
        if (l2 != null) {
            SuperPassPurchaseSharedViewModel l3 = confirmSuperPassPurchaseFragment.l();
            long longValue = l2.longValue();
            l3.m = longValue;
            l3.c.b("keyStartTime", Long.valueOf(longValue));
            ba1 ba1 = confirmSuperPassPurchaseFragment.h;
            if (ba1 != null) {
                ba1.c.b("keyPassStartTime", Long.valueOf(l2.longValue()));
                return;
            }
            n86.l("viewModel");
            throw null;
        }
    }
}
