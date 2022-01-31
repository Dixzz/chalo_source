package defpackage;

import app.zophop.ui.fragments.superpassPurchase.SuperPassBasicUserDetailsFragment;

/* renamed from: y41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class y41 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassBasicUserDetailsFragment f3995a;

    public /* synthetic */ y41(SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment) {
        this.f3995a = superPassBasicUserDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment = this.f3995a;
        String str = (String) obj;
        int i = SuperPassBasicUserDetailsFragment.i;
        n86.e(superPassBasicUserDetailsFragment, "this$0");
        if (str != null) {
            T t = superPassBasicUserDetailsFragment.f;
            n86.c(t);
            ((px) t).c.setText(ui1.w(str));
        }
    }
}
