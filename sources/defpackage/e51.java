package defpackage;

import app.zophop.models.mTicketing.Gender;
import app.zophop.ui.fragments.superpassPurchase.SuperPassBasicUserDetailsFragment;

/* renamed from: e51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class e51 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassBasicUserDetailsFragment f928a;

    public /* synthetic */ e51(SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment) {
        this.f928a = superPassBasicUserDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment = this.f928a;
        Gender gender = (Gender) obj;
        int i = SuperPassBasicUserDetailsFragment.i;
        n86.e(superPassBasicUserDetailsFragment, "this$0");
        T t = superPassBasicUserDetailsFragment.f;
        n86.c(t);
        ((px) t).e.setText(gender == null ? null : gender.name());
    }
}
