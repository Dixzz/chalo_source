package defpackage;

import app.zophop.ui.fragments.BasicUserDetailsFragment;

/* renamed from: bo0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class bo0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasicUserDetailsFragment f455a;

    public /* synthetic */ bo0(BasicUserDetailsFragment basicUserDetailsFragment) {
        this.f455a = basicUserDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        BasicUserDetailsFragment basicUserDetailsFragment = this.f455a;
        int i = BasicUserDetailsFragment.i;
        n86.e(basicUserDetailsFragment, "this$0");
        String e = jh1.e((Long) obj);
        n86.d(e, "getDateInMonthRoman(lPassStartTimeStamp)");
        if (e.length() > 0) {
            T t = basicUserDetailsFragment.f;
            n86.c(t);
            ((gx) t).f.setText(e);
        }
    }
}
