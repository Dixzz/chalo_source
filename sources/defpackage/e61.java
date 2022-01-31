package defpackage;

import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofsOverviewFragment;
import defpackage.su;

/* renamed from: e61  reason: default package */
/* compiled from: SuperPassUserProofsOverviewFragment.kt */
public final class e61 implements su.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassUserProofsOverviewFragment f929a;

    public e61(SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment) {
        this.f929a = superPassUserProofsOverviewFragment;
    }

    @Override // defpackage.su.a
    public void a(String str) {
        n86.e(str, "lFullName");
        ga1 ga1 = this.f929a.g;
        if (ga1 != null) {
            ga1.l = str;
            ga1.c.b("keyFullName", str);
            String str2 = ga1.l;
            ga1.c.b("keyIsNameChangeCompleted", Boolean.valueOf(!(str2 == null || str2.length() == 0)));
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
