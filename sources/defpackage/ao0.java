package defpackage;

import app.zophop.ui.fragments.BasicUserDetailsFragment;

/* renamed from: ao0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ao0 implements gm4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ em4 f270a;
    public final /* synthetic */ BasicUserDetailsFragment b;

    public /* synthetic */ ao0(em4 em4, BasicUserDetailsFragment basicUserDetailsFragment) {
        this.f270a = em4;
        this.b = basicUserDetailsFragment;
    }

    @Override // defpackage.gm4
    public final void a(Object obj) {
        em4 em4 = this.f270a;
        BasicUserDetailsFragment basicUserDetailsFragment = this.b;
        Long l = (Long) obj;
        int i = BasicUserDetailsFragment.i;
        n86.e(em4, "$lMaterialDatePicker");
        n86.e(basicUserDetailsFragment, "this$0");
        Long l2 = (Long) em4.e();
        if (l2 != null) {
            a81 j = basicUserDetailsFragment.j();
            String c = jh1.c(l2.longValue());
            n86.d(c, "getDateFromEpochTime(lDobTime)");
            n86.e(c, "lDob");
            j.c.b("keyDob", c);
            j.d();
        }
    }
}
