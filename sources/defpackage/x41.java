package defpackage;

import app.zophop.ui.fragments.superpassPurchase.SuperPassBasicUserDetailsFragment;

/* renamed from: x41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class x41 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassBasicUserDetailsFragment f3881a;

    public /* synthetic */ x41(SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment) {
        this.f3881a = superPassBasicUserDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment = this.f3881a;
        Boolean bool = (Boolean) obj;
        int i = SuperPassBasicUserDetailsFragment.i;
        n86.e(superPassBasicUserDetailsFragment, "this$0");
        n86.d(bool, "lAreAllRequiredFieldsSelected");
        if (bool.booleanValue()) {
            T t = superPassBasicUserDetailsFragment.f;
            n86.c(t);
            ((px) t).b.setAlpha(1.0f);
        } else {
            T t2 = superPassBasicUserDetailsFragment.f;
            n86.c(t2);
            ((px) t2).b.setAlpha(0.4f);
        }
        T t3 = superPassBasicUserDetailsFragment.f;
        n86.c(t3);
        ((px) t3).b.setEnabled(bool.booleanValue());
    }
}
