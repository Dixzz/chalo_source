package defpackage;

import app.zophop.ui.fragments.superpassPurchase.SuperPassBasicUserDetailsFragment;

/* renamed from: c51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class c51 implements gm4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ em4 f522a;
    public final /* synthetic */ SuperPassBasicUserDetailsFragment b;

    public /* synthetic */ c51(em4 em4, SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment) {
        this.f522a = em4;
        this.b = superPassBasicUserDetailsFragment;
    }

    @Override // defpackage.gm4
    public final void a(Object obj) {
        em4 em4 = this.f522a;
        SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment = this.b;
        Long l = (Long) obj;
        int i = SuperPassBasicUserDetailsFragment.i;
        n86.e(em4, "$lMaterialDatePicker");
        n86.e(superPassBasicUserDetailsFragment, "this$0");
        Long l2 = (Long) em4.e();
        if (l2 != null) {
            da1 j = superPassBasicUserDetailsFragment.j();
            String c = jh1.c(l2.longValue());
            n86.d(c, "getDateFromEpochTime(lDobTime)");
            n86.e(c, "lDob");
            j.c.b("keyDob", c);
            j.d();
        }
    }
}
