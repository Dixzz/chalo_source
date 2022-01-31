package defpackage;

import app.zophop.ui.fragments.UserProofsOverviewFragment;
import defpackage.su;

/* renamed from: mx0  reason: default package */
/* compiled from: UserProofsOverviewFragment.kt */
public final class mx0 implements su.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProofsOverviewFragment f2456a;

    public mx0(UserProofsOverviewFragment userProofsOverviewFragment) {
        this.f2456a = userProofsOverviewFragment;
    }

    @Override // defpackage.su.a
    public void a(String str) {
        n86.e(str, "lFullName");
        g91 g91 = this.f2456a.g;
        if (g91 != null) {
            g91.l = str;
            g91.c.b("keyFullName", str);
            String str2 = g91.l;
            g91.c.b("keyIsNameChangeCompleted", Boolean.valueOf(!(str2 == null || str2.length() == 0)));
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
