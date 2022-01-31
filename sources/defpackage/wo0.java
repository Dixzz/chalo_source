package defpackage;

import app.zophop.ui.fragments.ConfirmMPassPurchaseFragment;

/* renamed from: wo0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class wo0 implements gm4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ em4 f3812a;
    public final /* synthetic */ ConfirmMPassPurchaseFragment b;

    public /* synthetic */ wo0(em4 em4, ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment) {
        this.f3812a = em4;
        this.b = confirmMPassPurchaseFragment;
    }

    @Override // defpackage.gm4
    public final void a(Object obj) {
        em4 em4 = this.f3812a;
        ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment = this.b;
        Long l = (Long) obj;
        int i = ConfirmMPassPurchaseFragment.k;
        n86.e(em4, "$lMaterialDatePicker");
        n86.e(confirmMPassPurchaseFragment, "this$0");
        Long l2 = (Long) em4.e();
        if (l2 != null) {
            confirmMPassPurchaseFragment.k().g.setStartingTime(l2.longValue());
            c81 c81 = confirmMPassPurchaseFragment.h;
            if (c81 != null) {
                c81.c.b("keyPassStartTime", Long.valueOf(l2.longValue()));
                return;
            }
            n86.l("viewModel");
            throw null;
        }
    }
}
