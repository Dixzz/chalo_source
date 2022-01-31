package defpackage;

import app.zophop.ui.fragments.UserDetailsFragment;
import defpackage.nm0;

/* renamed from: hx0  reason: default package */
/* compiled from: UserDetailsFragment */
public class hx0 implements nm0.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1439a;
    public final /* synthetic */ String b;
    public final /* synthetic */ jx0 c;

    public hx0(jx0 jx0, String str, String str2) {
        this.c = jx0;
        this.f1439a = str;
        this.b = str2;
    }

    @Override // defpackage.nm0.b
    public void a() {
        xt.f3961a.c().T(this.f1439a, this.c.f1990a.f.getAgencyName(), this.b);
        if (UserDetailsFragment.a(this.c.f1990a)) {
            UserDetailsFragment userDetailsFragment = this.c.f1990a;
            userDetailsFragment.y = vn.S0(userDetailsFragment);
        }
    }
}
