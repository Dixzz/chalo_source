package defpackage;

import app.zophop.models.mTicketing.Gender;
import app.zophop.ui.fragments.superpassPurchase.SuperPassBasicUserDetailsFragment;
import defpackage.mm0;

/* renamed from: a61  reason: default package */
/* compiled from: SuperPassBasicUserDetailsFragment.kt */
public final class a61 implements mm0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassBasicUserDetailsFragment f126a;

    public a61(SuperPassBasicUserDetailsFragment superPassBasicUserDetailsFragment) {
        this.f126a = superPassBasicUserDetailsFragment;
    }

    @Override // defpackage.mm0.a
    public void a(Gender gender) {
        n86.e(gender, "lSelectedGender");
        da1 j = this.f126a.j();
        n86.e(gender, "lGender");
        j.c.b("keyGender", gender);
        j.d();
    }
}
