package defpackage;

import app.zophop.ui.fragments.superpassPurchase.SuperPassBasicUserDetailsFragment;

/* renamed from: a51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class a51 implements gm4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ em4 f118a;
    public final /* synthetic */ SuperPassBasicUserDetailsFragment b;

    public /* synthetic */ a51(em4 em4, SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment) {
        this.f118a = em4;
        this.b = superPassBasicUserDetailsFragment;
    }

    @Override // defpackage.gm4
    public final void a(Object obj) {
        em4 em4 = this.f118a;
        SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment = this.b;
        Long l = (Long) obj;
        int i = SuperPassBasicUserDetailsFragment.i;
        n86.e(em4, "$lMaterialDatePicker");
        n86.e(superPassBasicUserDetailsFragment, "this$0");
        Long l2 = (Long) em4.e();
        if (l2 != null) {
            da1 j = superPassBasicUserDetailsFragment.j();
            j.c.b("keyPassStartDate", Long.valueOf(l2.longValue()));
            j.d();
        }
    }
}
