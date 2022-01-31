package defpackage;

import app.zophop.ui.fragments.superpassPurchase.SuperPassBasicUserDetailsFragment;

/* renamed from: d51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class d51 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassBasicUserDetailsFragment f789a;

    public /* synthetic */ d51(SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment) {
        this.f789a = superPassBasicUserDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment = this.f789a;
        int i = SuperPassBasicUserDetailsFragment.i;
        n86.e(superPassBasicUserDetailsFragment, "this$0");
        String e = jh1.e((Long) obj);
        n86.d(e, "getDateInMonthRoman(lPassStartTimeStamp)");
        if (e.length() > 0) {
            T t = superPassBasicUserDetailsFragment.f;
            n86.c(t);
            ((px) t).f.setText(e);
        }
    }
}
