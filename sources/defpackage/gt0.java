package defpackage;

import app.zophop.models.mTicketing.Gender;
import app.zophop.ui.fragments.BasicUserDetailsFragment;
import defpackage.mm0;

/* renamed from: gt0  reason: default package */
/* compiled from: BasicUserDetailsFragment.kt */
public final class gt0 implements mm0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasicUserDetailsFragment f1299a;

    public gt0(BasicUserDetailsFragment basicUserDetailsFragment) {
        this.f1299a = basicUserDetailsFragment;
    }

    @Override // defpackage.mm0.a
    public void a(Gender gender) {
        n86.e(gender, "lSelectedGender");
        a81 j = this.f1299a.j();
        n86.e(gender, "lGender");
        j.c.b("keyGender", gender);
        j.d();
    }
}
